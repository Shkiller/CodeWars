import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class TotalAreaCoveredByRectangles {
    public static void main(String[] args) {
        int[][] rectangles = new int[][]{{3, 3, 8, 5}, {6, 3, 8, 9}, {11, 6, 14, 12}};
        List<Rectangle> rList = new ArrayList<>();
        List<Rectangle> removeList;
        List<Rectangle> addList;
        int sum = 0;
        for (var r : rectangles) {
            removeList = new ArrayList<>();
            addList = new ArrayList<>();
            Rectangle rectangle = new Rectangle(r[0], r[1], -r[0] + r[2], -r[1] + r[3]);
            for (var rec : rList) {
                if (rec.intersects(rectangle)) {
                    Rectangle interRec = rec.intersection(rectangle);
                    Rectangle rectangle1 = new Rectangle(rec.x, interRec.y + interRec.height, -rec.x + interRec.x, rec.height - interRec.height - (-rec.y + interRec.y));
                    Rectangle rectangle2 = new Rectangle(interRec.x, interRec.y + interRec.height, interRec.width, rec.height - interRec.height - (-rec.y + interRec.y));
                    Rectangle rectangle3 = new Rectangle(interRec.x + interRec.width, interRec.y + interRec.height, rec.width - interRec.width - (-rec.x + interRec.x), rec.height - interRec.height - (-rec.y + interRec.y));
                    Rectangle rectangle4 = new Rectangle(interRec.x + interRec.width, interRec.y, rec.width - interRec.width - (-rec.x + interRec.x), interRec.height);
                    Rectangle rectangle5 = new Rectangle(interRec.x + interRec.width, rec.y, rec.width - interRec.width - (-rec.x + interRec.x), (-rec.y + interRec.y));
                    Rectangle rectangle6 = new Rectangle(interRec.x, rec.y, interRec.width, (-rec.y + interRec.y));
                    Rectangle rectangle7 = new Rectangle(rec.x, rec.y, -rec.x + interRec.x, (-rec.y + interRec.y));
                    Rectangle rectangle8 = new Rectangle(rec.x, interRec.y, -rec.x + interRec.x, interRec.height);

                    if (rectangle1.width > 0 && rectangle1.height > 0) {
                        addList.add(rectangle1);
                    }
                    if (rectangle2.width > 0 && rectangle2.height > 0) {
                        addList.add(rectangle2);
                    }
                    if (rectangle3.width > 0 && rectangle3.height > 0) {
                        addList.add(rectangle3);
                    }
                    if (rectangle4.width > 0 && rectangle4.height > 0) {
                        addList.add(rectangle4);
                    }
                    if (rectangle5.width > 0 && rectangle5.height > 0) {
                        addList.add(rectangle5);
                    }
                    if (rectangle6.width > 0 && rectangle6.height > 0) {
                        addList.add(rectangle6);
                    }
                    if (rectangle7.width > 0 && rectangle7.height > 0) {
                        addList.add(rectangle7);
                    }
                    if (rectangle8.width > 0 && rectangle8.height > 0) {
                        addList.add(rectangle8);
                    }
                    removeList.add(rec);

                }

            }
            rList.removeAll(removeList);
            rList.addAll(addList);
            rList.add(rectangle);
        }
        for (var r : rList) {
            sum += r.height * r.width;
        }


        System.out.println(sum);
    }
}
