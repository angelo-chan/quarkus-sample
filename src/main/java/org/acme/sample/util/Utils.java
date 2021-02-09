package org.acme.sample.util;

import com.google.common.io.BaseEncoding;
import org.acme.sample.setting.LocalDateConverter;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public abstract class Utils {

    public static final String BASIC = "Basic ";

    public static final String BEARER = "Bearer ";

    public static final ZoneId DEFAULT_ZONE_ID = ZoneId.of("Asia/Shanghai");

    public static final LocalDateConverter LOCAL_DATE_CONVERTER = new LocalDateConverter();

    /**
     * Get basic authorization
     *
     * @param clientId     client id
     * @param clientSecret client secret
     * @return basic authorization
     */
    public static String getBasicAuthorization(String clientId, String clientSecret) {
        return BASIC + BaseEncoding.base64().encode((clientId + ":" + clientSecret).getBytes());
    }

    /**
     * Get bearer authorization
     *
     * @param token token
     * @return bearer authorization
     */
    public static String getBearerAuthorization(String token) {
        return BEARER + token;
    }

    /**
     * Get date from local date in Asia/Shanghai
     *
     * @param date local date
     * @return date
     */
    public static Date dateFrom(LocalDate date) {
        if (date == null) {
            return null;
        }
        return Date.from(date.atStartOfDay(DEFAULT_ZONE_ID).toInstant());
    }
}
