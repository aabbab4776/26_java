package day10;

public class first {

    static class CCTV {
        private String resolution;

        public CCTV(String resolution) {
            this.resolution = resolution;
        }

        protected String getResolution() {
            return resolution;
        }
    }

    static class AICCTV extends CCTV {
        private boolean face;

        public AICCTV(String resolution, boolean face) {
            super(resolution);
            this.face = face;
        }

        public void printInfo() {
            System.out.println(getResolution() + "급 해상도");
            System.out.println("얼굴 인식: " + face);
        }
    }

    public static void main(String[] args) {
        AICCTV ai = new AICCTV("FHD", true);
        ai.printInfo();
    }
}
