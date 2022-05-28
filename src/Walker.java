import java.io.IOException;

public class Walker {
    public static void main(String[] args) throws IOException {

        int [] output = new int [4];
        int a = 12;
        int b = 20;
        int c = 18;
        int alpha = 45;
        int beta = 30;
        int gamma = 60;
        double ax, ay, bx, by, cx, cy;
        ax = 0.0 + Math.cos(Math.toRadians(alpha)) * a;
        ay = 0.0 + Math.sin(Math.toRadians(alpha)) * a;
        bx = ax + Math.cos(Math.toRadians(beta + 90)) * b;
        by = ay + Math.sin(Math.toRadians(beta + 90)) * b;
        cx = bx + Math.cos(Math.toRadians(gamma + 180)) * c;
        cy = by + Math.sin(Math.toRadians(gamma + 180)) * c;
        double c0 = Math.sqrt(cx * cx + cy * cy);
        double cosC0 = cx/c0;
        double angle = Math.toDegrees(Math.acos(cosC0));
        output[0] = (int) Math.round(c0);
        output[1] = (int) angle;
        double minutes = (angle - output[1]) * 60;
        output[2] = (int) minutes;
        double sec = (minutes - output[2]) * 60;
        output[3] = (int) sec;

    }
}
