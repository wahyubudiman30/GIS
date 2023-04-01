package com.wahyu.evakuasibencana;

public class DbContract {

    public static final String ROOT_URL = "http://192.168.1.27/ApiEvakuasiBencana/";
    public static String SERVER_LOGIN_URL = ROOT_URL+"checkLogin.php";
    public static String SERVER_REGISTER_URL = ROOT_URL+"createData.php";
    public static String SERVER_READ_URL = ROOT_URL+"lihatProfil.php";
    public static String URL_READ = ROOT_URL+"read_detail.php";
    public static String URL_EDIT = ROOT_URL+"edit_detail.php";
    public static String URL_UPLOAD = ROOT_URL+"upload.php";
    public static String URL_RESETPASS = ROOT_URL+"resetpass.php";

    public static String URL_ADD= ROOT_URL+"tambahLokasi.php";
    public static String URL_GET_ALL = ROOT_URL+"tampilSemuaLokasi.php";
    public static String URL_GET_EMP = ROOT_URL+"tampilLokasi.php?id=";
    public static String URL_UPDATE_EMP = ROOT_URL+"ubahLokasi.php";
    public static String URL_DELETE_EMP = ROOT_URL+"hapusLokasi.php?id=";


    //public static final String SERVER_LOGIN_URL = "http://192.168.1.12/ApiEvakuasiBencana/checkLogin.php";
    //public static final String SERVER_REGISTER_URL = "http://192.168.1.12/ApiEvakuasiBencana/createData.php";
    //public static final String URL_READ = "http://192.168.1.12/ApiEvakuasiBencana/read_detail.php";
    //public static final String URL_EDIT = "http://192.168.1.12/ApiEvakuasiBencana/edit_detail.php";
    //public static final String URL_UPLOAD = "http://192.168.1.12/ApiEvakuasiBencana/upload.php";

    //public static final String URL_ADD="http://192.168.1.12/ApiEvakuasiBencana/tambahLokasi.php";
    //public static final String URL_GET_ALL = "http://192.168.1.12/ApiEvakuasiBencana/tampilSemuaLokasi.php";
    //public static final String URL_GET_EMP = "http://192.168.1.12/ApiEvakuasiBencana/tampilLokasi.php?id=";
    //public static final String URL_UPDATE_EMP = "http://192.168.1.12/ApiEvakuasiBencana/ubahLokasi.php";
    //public static final String URL_DELETE_EMP = "http://192.168.1.12/ApiEvakuasiBencana/hapusLokasi.php?id=";

    public static final String URL_GET_EMP_ADM = "http://192.168.1.27/ApiEvakuasiBencana/tampilAdmin.php?id=";
    public static final String URL_UPDATE_EMP_ADM = "http://192.168.1.27/ApiEvakuasiBencana/ubahAdmin.php";

    public static final String KEY_EMP_ID = "id";
    public static final String KEY_EMP_NAMA = "nama_lokasi";
    public static final String KEY_EMP_ALAMAT = "alamat";
    public static final String KEY_EMP_KELURAHAN = "kelurahan";
    public static final String KEY_EMP_KECAMATAN = "kecamatan";
    public static final String KEY_EMP_LATITUDE = "latitude";
    public static final String KEY_EMP_LONGITUDE = "longitude";

    //JSON Tags
    public static final String TAG_JSON_ARRAY="result";
    public static final String TAG_ID = "id";
    public static final String TAG_NAMA = "nama_lokasi";
    public static final String TAG_ALAMAT = "alamat";
    public static final String TAG_KELURAHAN = "kelurahan";
    public static final String TAG_KECAMATAN = "kecamatan";
    public static final String TAG_LATITUDE = "latitude";
    public static final String TAG_LONGITUDE = "longitude";
    public static final String EMP_ID = "emp_id";


    public static final String KEY_EMP_ID_ADM = "id";
    public static final String KEY_EMP_NAMA_ADM = "username";
    public static final String KEY_EMP_EMAIL_ADM = "email";
    public static final String KEY_EMP_TTL_ADM = "ttl";
    public static final String KEY_EMP_JK_ADM = "jk";
    public static final String KEY_EMP_TELEPON_ADM = "telepon";
    public static final String KEY_EMP_JABATAN_ADM = "jabatan";
    public static final String KEY_EMP_ALAMAT_ADM = "alamat";

    public static final String TAG_ID_ADM = "id";
    public static final String TAG_NAMA_ADM = "username";
    public static final String TAG_EMAIL_ADM = "email";
    public static final String TAG_TTL_ADM = "ttl";
    public static final String TAG_JK_ADM = "jk";
    public static final String TAG_TELEPON_ADM = "telepon";
    public static final String TAG_JABATAN_ADM = "jabatan";
    public static final String TAG_ALAMAT_ADM = "alamat";
    public static final String EMP_ID_ADM = "emp_id_adm";
}
