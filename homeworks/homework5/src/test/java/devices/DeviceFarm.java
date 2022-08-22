package devices;

public enum DeviceFarm {
    //this field for all devices, we can add more devices here and than we can use in tests
    ANDROID_OREO("src/test/resources/capabilities/pixel-2-android-oreo.json");

    public  String path;
    DeviceFarm(String path) {
        this.path = path;
    }
}
