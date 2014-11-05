/*
 * 由系统于2014-10-08 15:51:26生成。
 */

package com.hehua.user.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.hehua.commons.time.DateUtils;
import com.hehua.framework.subscribe.RedisPubSubService;
import com.hehua.user.dao.UserDAO;
import com.hehua.user.domain.Qrcode;
import com.hehua.user.domain.User;
import com.hehua.user.exeception.QRCodeNotExistException;
import com.hehua.user.exeception.QRCodeStatusErrorException;
import org.apache.log4j.Logger;

import javax.inject.Inject;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Hashtable;
import java.util.UUID;

@javax.inject.Named
public class QrcodeService extends QrcodeServiceI {

    private static final Logger log = Logger.getLogger(QrcodeService.class);

    @Inject
    private UserDAO userDAO;

    public static final String QRCODE_SCHEME_KEY = "qrcode_scheme";

    public Qrcode genQrcode() {
        Qrcode qrcode = new Qrcode();
        qrcode.setUuid(UUID.randomUUID().toString());
        qrcode.setStatus(0);
        qrcode.setAddtime(DateUtils.unix_timestamp());
        qrcode.setUid(0);
        dao.createQrcode(qrcode);
        return qrcode;
    }

    public int ack(long uid, String uuid) throws QRCodeNotExistException,
            QRCodeStatusErrorException {
        Qrcode qrcode = dao.getQrcodeByUuid(uuid);
        if (qrcode == null) {
            throw new QRCodeNotExistException();
        }
        if (qrcode.getStatus() > Qrcode.STATUS_SCANED) {
            throw new QRCodeStatusErrorException();
        }
        qrcode.setUid(uid);
        qrcode.setStatus(Qrcode.STATUS_SCANED);
        dao.updateQrcodeById(qrcode);
        RedisPubSubService.getInstance().post("qr:" + uuid, String.valueOf(qrcode.getStatus()));
        return qrcode.getStatus();
    }

    public int login(long uid, String uuid) throws QRCodeNotExistException,
            QRCodeStatusErrorException {
        Qrcode qrcode = dao.getQrcodeByUuid(uuid);
        if (qrcode == null) {
            throw new QRCodeNotExistException();
        }
        if (qrcode.getStatus() != Qrcode.STATUS_SCANED) {
            throw new QRCodeStatusErrorException();
        }
        if (qrcode.getUid() != uid) {
            throw new QRCodeStatusErrorException();
        }
        qrcode.setStatus(Qrcode.STATUS_LOGINED);
        dao.updateQrcodeById(qrcode);
        RedisPubSubService.getInstance().post("qr:" + uuid, String.valueOf(qrcode.getStatus()));
        return qrcode.getStatus();
    }

    public int query(String uuid) throws QRCodeNotExistException {
        Qrcode qrcode = dao.getQrcodeByUuid(uuid);
        if (qrcode == null) {
            throw new QRCodeNotExistException();
        }
        return qrcode.getStatus();
    }

    public User getUserByUuid(String uuid) {
        Qrcode qrcode = dao.getQrcodeByUuid(uuid);
        if (qrcode == null) {
            return null;
        }
        return userDAO.getUserById(qrcode.getUid());
    }

    public BufferedImage genQRCodeImage(String text) throws WriterException {
        int size = 150;
        Hashtable<EncodeHintType, ErrorCorrectionLevel> hintMap = new Hashtable<>();
        hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix byteMatrix = qrCodeWriter
                .encode(text, BarcodeFormat.QR_CODE, size, size, hintMap);

        int width = byteMatrix.getWidth();
        BufferedImage image = new BufferedImage(width, width, BufferedImage.TYPE_INT_RGB);
        image.createGraphics();
        Graphics2D graphics = (Graphics2D) image.getGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, width, width);
        graphics.setColor(Color.BLACK);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                if (byteMatrix.get(i, j)) {
                    graphics.fillRect(i, j, 1, 1);
                }
            }
        }
        return image;
    }

}
