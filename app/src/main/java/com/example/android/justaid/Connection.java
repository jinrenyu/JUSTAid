package com.example.android.justaid;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.android.justaid.info.BookInfo;
import com.example.android.justaid.info.Course;
import com.example.android.justaid.info.Score;
import com.example.android.justaid.util.CacherUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by 浩然 on 2017-4-16.
 */

public class Connection {
    public void setJwxtCookie(String jwxtCookie) {
        this.jwxtCookie = jwxtCookie;
    }

    private String jwxtCookie = null;
    private String szsdCookie = null;

    public void setLibCookie(String libCookie) {
        this.libCookie = libCookie;
    }

    private String libCookie = null;
    private int timeOut;

    //单例模式
    private static Connection INSTANCE = new Connection();

    private Connection() {
        timeOut = 10000;
    }

    public static Connection getInstance() {
        return INSTANCE;
    }

    public Map<String, String> szsdLogin(String username, String password, Context context) {
        try {
            String loginURL = "http://120.27.117.34:555/upcaid/api?command=logToSzsd"
                    + "&username=" + username
                    + "&password=" + password;
            URL url = new URL(loginURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.connect();
            szsdCookie = connection.getHeaderField("szsdCookie");
            String selfInfo = CacherUtils.getHttpString(connection);
            JSONObject jsonObject = JSONObject.fromObject(selfInfo);
            Map<String, String> infoMap = (Map<String, String>) jsonObject.get("map");
            if (infoMap != null) {
                return infoMap;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
//    public boolean szsdLogin(String username, String password, Context context) {
//        try {
//            String loginURL = "https://cacher.cc:8443/SZSDServlet2/szsd?command=logToSzsd"
//                    + "&username=" + username
//                    + "&password=" + password;
//            URL url = new URL(loginURL);
//            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
//            //https证书设置
//            InputStream inputStream = context.getResources().openRawResource(R.raw.tomcat);
//            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
//            Certificate certificate = certificateFactory.generateCertificate(inputStream);
//            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
//            keyStore.load(null, null);
//            keyStore.setCertificateEntry("trust", certificate);
//
//            SSLContext sslContext = SSLContext.getInstance("TLS");
//            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
//            trustManagerFactory.init(keyStore);
//
//            sslContext.init(null, trustManagerFactory.getTrustManagers(), new SecureRandom());
//
//            httpsURLConnection.setSSLSocketFactory(sslContext.getSocketFactory());
//            httpsURLConnection.setConnectTimeout(timeOut);
//            httpsURLConnection.setReadTimeout(timeOut);
//            httpsURLConnection.connect();
//
//            szsdCookie = httpsURLConnection.getHeaderField("szsdCookie");
//            if (szsdCookie != null) {
//                return true;
//            }
//            if (httpsURLConnection != null) {
//                httpsURLConnection.disconnect();
//            }
//        } catch (UnknownHostException e) {
//            System.out.println("域名未解析，未联网？");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return false;
//    }


    public Map<String, String> getLibAndCardInfo() {
        try {
            URL url = new URL("http://120.27.117.34:555/upcaid/api?command=getLibAndCardInfo");
            HttpURLConnection
                    httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestProperty("szsdCookie", szsdCookie);
            httpURLConnection.setConnectTimeout(timeOut);
            httpURLConnection.setReadTimeout(timeOut);
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            String resqContent = CacherUtils.getHttpString(httpURLConnection);
            JSONObject jsonObject = JSONObject.fromObject(resqContent);
            Map<String, String> a = (Map<String, String>) jsonObject.get("map");
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return a;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Course> getCourseInfo(String xq, String zc) {
        if (jwxtCookie == null) {
            getJwxtCookie();
        }
        System.out.println(jwxtCookie);
        try {
            ArrayList<Course> courseList;
//            courseList.add(new Course("AAAA"));
            String courseUrl = "http://120.27.117.34:555/upcaid/api?command=getCourseInfo"
                    + "&xq=" + xq
                    + "&zc=" + zc;
            URL url = new URL(courseUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestProperty("jwxtCookie", jwxtCookie);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(timeOut);
            httpURLConnection.setReadTimeout(timeOut);
            httpURLConnection.connect();
            String jsonStr = CacherUtils.getHttpString(httpURLConnection);
            System.out.println("获取的课表");
            System.out.println(jsonStr);
            courseList = getCourseList(jsonStr);
            httpURLConnection.disconnect();
            return courseList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
    * 返回一个列表 第一个HashMap为学分绩信息
    * */
    public List<HashMap<String, String>> getScore(String kksj) {
        if (jwxtCookie == null) {
            getJwxtCookie();
        }
        try {
            List<HashMap<String, String>> data ;
            String scoreUrl = "http://120.27.117.34:555/upcaid/api?command=getScore"
                    + "&kksj=" + kksj;
            URL url = new URL(scoreUrl);
            HttpURLConnection
                    httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestProperty("jwxtCookie", jwxtCookie);
            //httpURLConnection.setConnectTimeout(timeOut);
            //httpURLConnection.setReadTimeout(timeOut);
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            ObjectInputStream inputStream = new ObjectInputStream(httpURLConnection.getInputStream());


            data = (List<HashMap<String, String>>) inputStream.readObject();
            if (inputStream != null) {
                inputStream.close();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return data;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param href 成绩详细信息的查询链接，从成绩的HashMap中用xx（详细）获得
     * @return 返回 JSONObject pscj,pscjbl,qzcj,qzcjbl,qmcj,qmcjbl,zcj
     * @author xhaiben
     */
    public JSONObject getScoreDetail(String href) {
        if (jwxtCookie == null) {
            getJwxtCookie();
        }
        href = href.replace("&", "*");
        try {
            URL url = new URL("http://120.27.117.34:555/upcaid/getScoreDetail?href=" + href);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestProperty("jwxtCookie", jwxtCookie);
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            String result = CacherUtils.getHttpString(httpURLConnection);
            httpURLConnection.disconnect();

            JSONObject jsonObject = JSONObject.fromObject(result);
            String str = jsonObject.toString();
            str = str.replace(" ", "?");
            System.out.println(str);
            jsonObject = JSONObject.fromObject(str);
            System.out.println(jsonObject);
            return jsonObject;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    private ArrayList<Course> getCourseList(String jsonStr) {
        ArrayList<Course> courseList = new ArrayList<>();
        JSONArray jsonArray = JSONArray.fromObject(jsonStr);
        for (int i = 0; i < jsonArray.size(); i++) {
            Course item = new Course();
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            Set<Integer> tempSet = new HashSet<>();
            JSONArray tempArray = jsonObject.getJSONArray("expected");
            for (int j = 0; j < tempArray.size(); j++) {
                tempSet.add(tempArray.getInt(j));
            }
            item.setExpected(tempSet);
            item.setCourseName(jsonObject.getString("courseName"));
            item.setClassRoom(jsonObject.getString("classRoom"));
            item.setTeacherName(jsonObject.getString("teacherName"));
            item.setBeginLesson(jsonObject.getInt("beginLesson"));
            item.setBeginWeek(jsonObject.getInt("beginWeek"));
            item.setCourseType(jsonObject.getInt("courseType"));
            item.setDay(jsonObject.getInt("day"));
            item.setEndLesson(jsonObject.getInt("endLesson"));
            item.setEndWeek(jsonObject.getInt("endWeek"));
            courseList.add(item);
        }
        return courseList;
    }

    public Map<String, String> getCurrentClassRoom() {
        try {
            URL url = new URL("http://120.27.117.34:555/upcaid/api?command=getCurrentClassRoom");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(timeOut);
            httpURLConnection.setReadTimeout(timeOut);
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            ObjectInputStream inputStream = new ObjectInputStream(httpURLConnection.getInputStream());
            Map<String, String> classRoomMap = (Map<String, String>) inputStream.readObject();
            if (inputStream != null) {
                inputStream.close();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return classRoomMap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Map<String, String> getClassRoom(String week, String day, String n) {
        try {
            String classRoomUrl = "http://120.27.117.34:555/upcaid/api?command=getAvailableClassRoom"
                    + "&week=" + week
                    + "&day=" + day
                    + "&n=" + n;
            URL url = new URL(classRoomUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(timeOut);
            httpURLConnection.setReadTimeout(timeOut);
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            ObjectInputStream inputStream = new ObjectInputStream(httpURLConnection.getInputStream());
            Map<String, String> classRoomMap = (Map<String, String>) inputStream.readObject();
            if (inputStream != null) {
                inputStream.close();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return classRoomMap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getVersionCode() {
        try {
            URL url = new URL("http://120.27.117.34:555/upcaid/api?command=checkUpdate");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(timeOut);
            httpURLConnection.setReadTimeout(timeOut);
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            InputStream inputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            Scanner scanner = new Scanner(bufferedReader);
            StringBuilder stringBuilder = new StringBuilder();
            while (scanner.hasNextLine()) {
                stringBuilder.append(scanner.nextLine());
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return Integer.parseInt(stringBuilder.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Map<String, Object> getUpdateInfo() {
        try {
            URL url = new URL("http://120.27.117.34:555/upcaid/api?command=getUpdateInfo");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(timeOut);
            httpURLConnection.setReadTimeout(timeOut);
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            InputStream inputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            Scanner scanner = new Scanner(bufferedReader);
            StringBuilder stringBuilder = new StringBuilder();
            while (scanner.hasNextLine()) {
                stringBuilder.append(scanner.nextLine());
            }
            JSONObject jsonObject = JSONObject.fromObject(stringBuilder.toString());
            String info = jsonObject.getString("info");
            String link = jsonObject.getString("link");
            Map<String, Object> updateInfo = new HashMap<>();
            String[] strings;
            if (info.contains(";")) {
                strings = info.split("[;]");
            } else {
                strings = new String[]{info};
            }
            updateInfo.put("info", strings);
            updateInfo.put("link", link);
            if (inputStream != null) {
                inputStream.close();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return updateInfo;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<BookInfo> getBookList() {
        if (libCookie == null) {
            try {
                URL url = new URL("http://120.27.117.34:555/upcaid/api?command=logToLib&cookie=" + szsdCookie);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setDoInput(true);
                httpURLConnection.connect();
                libCookie = httpURLConnection.getHeaderField("libCookie");
                httpURLConnection.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(libCookie);
        try {
            URL url = new URL("http://120.27.117.34:555/upcaid/api?command=getBookList&cookie=" + libCookie);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setDoInput(true);
            String resqContent = CacherUtils.getHttpString(httpURLConnection);
            httpURLConnection.disconnect();
            ArrayList<BookInfo> bookInfoList = new ArrayList<>();
            JSONArray jsonArray = JSONArray.fromObject(resqContent);
            for (int i = 0; i < jsonArray.size(); i++) {
                BookInfo item = new BookInfo();
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                item.setBookName(jsonObject.getString("bookName"));
                item.setAuthorName(jsonObject.getString("authorName"));
                item.setBarCode(jsonObject.getString("barCode"));
                item.setBorrowDate(jsonObject.getString("borrowDate"));
                item.setReturnDate(jsonObject.getString("returnDate"));
                item.setCheckNum(jsonObject.getString("checkNum"));
                bookInfoList.add(item);
            }
            return bookInfoList;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("没有借书");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Bitmap getLibCaptcha() {
        try {
            URL url = new URL("http://120.27.117.34:555/upcaid/api?command=getLibCaptcha&cookie=" + libCookie);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            BufferedInputStream inputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            byte[] buff = new byte[1024];
            int length = inputStream.read(buff);
            Bitmap bitmap = BitmapFactory.decodeByteArray(buff, 0, length);
            inputStream.close();
            httpURLConnection.disconnect();
            return bitmap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String renewBook(String bar_code, String check, String captcha) {
        try {
            URL url = new URL("http://120.27.117.34:555/upcaid/api?command=renewBook&cookie=" + libCookie
                    + "&bar_code=" + bar_code
                    + "&check=" + check
                    + "&captcha=" + captcha);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            InputStream inputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            Scanner scanner = new Scanner(bufferedReader);
            StringBuilder stringBuilder = new StringBuilder();
            while (scanner.hasNextLine()) {
                stringBuilder.append(scanner.nextLine());
            }
            return stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void feedback(String account, String feedback, String connect) {
        try {
            String urlStr = "http://120.27.117.34:555/upcaid/api?command=feedback";
            URL url = new URL(urlStr);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("account", account);
            jsonObject.put("connect", connect);
            jsonObject.put("content", feedback);
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            OutputStream outputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            writer.write(jsonObject.toString());
            writer.flush();
            writer.close();
            httpURLConnection.getInputStream().close();
            httpURLConnection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private boolean getJwxtCookie() {
        try {
            URL url = new URL("http://120.27.117.34:555/upcaid/api?command=getJwxtCookie&cookie=" + szsdCookie);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            jwxtCookie = httpURLConnection.getHeaderField("jwxtCookie");
            System.out.println(jwxtCookie);
            if (jwxtCookie != null) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return false;
    }
}