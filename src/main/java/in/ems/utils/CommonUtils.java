package in.ems.utils;

import in.ems.model.TxnLog;
import in.ems.response.ApiResponse;
import org.springframework.security.core.context.SecurityContextHolder;

import in.ems.security.UserPrincipal;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class CommonUtils {

    public static String getCurrentUserId() {
        UserPrincipal auth = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        return auth.getUserId();
    }

    public static String getTimeStamp() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(CommonConstants.YYYY_MM_DD_HH_mm_ss);
        return formatter.format(date);
    }

    

    /**
     * Create a new HashMap instance based on there generic types and returns
     * the same.
     *
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> HashMap<K, V> newHashMapInstance() {
        return new HashMap<>();
    }

    /**
     * Creates a new ArrayList instance based on there generic type and returns
     * the same.
     *
     * @param <E>
     * @return
     */
    public static <E> ArrayList<E> newArrayListInstance() {
        return new ArrayList<>();
    }


    /**
     * Creates a new ApiResponse instance the same.
     *
     * @return
     */
    public static ApiResponse getApiResponseInstance() {
        return new ApiResponse();
    }

    /**
     * Parse String to integer
     *
     * @param string
     * @return
     */
    public static Integer stringToInteger(String string) {
        return Integer.parseInt(string);
    }

    /**
     * Creates a new TxnLog instance the same.
     *
     * @return
     */
    public static TxnLog getTxnLogInstance() {
        return new TxnLog();
    }

    public static TxnLog getTxnObj(String incReq, String resp, String type) {
        TxnLog txn = getTxnLogInstance();
        txn.setIncReq(incReq);
        txn.setResponse(resp);
        txn.setTxnType(type);
        return txn;
    }

    
    
    
    public static Timestamp getCurrentTime() {
    	return new Timestamp(System.currentTimeMillis());
    	
    }
    
    public static Timestamp getSQLCurrentTime() {
    	return new Timestamp(System.currentTimeMillis());
    	
    }
    

}
