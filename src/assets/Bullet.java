package assets;

import java.awt.*;
import javax.swing.JPanel;

//子弹类
public class Bullet {
    //    static final int BULLET_STEP_X = 3;
//    static final int BULLET_WIDTH = 40;
    public int BULLET_STEP_Y = 15; // 子弹在Y轴速度
    public int m_posX = 0; // 子弹X坐标
    public int m_posY = 0; // 子弹Y坐标
    public boolean mFacus; // 消失状态
    private Image pic[] = null; // 状态（图片）数据
    private int mPlayID = 0; // 当前状态
    public int scale = 1; // 放大倍数

    public Bullet(String iconPrevURL, String iconAfterURL) { // 前缀与后缀路径
        pic = new Image[4];
        for (int i = 0; i < 4; i++)  // 只有四个状态
            pic[i] = Toolkit.getDefaultToolkit().getImage(iconPrevURL + i + iconAfterURL + ".png");
    }

    // 初始化
    public void init(int x, int y) {
        m_posX = x;
        m_posY = y;
        mFacus = true; // 默认发射
    }

    // 渲染子弹
    public void DrawBullet(Graphics g, JPanel i) {
        // 如果打中了敌人，不需要渲染
        if (!mFacus) {
            return;
        }
        int bulletWidth = pic[mPlayID].getWidth(null);
        int bulletHeight = pic[mPlayID].getHeight(null);

        g.drawImage(pic[mPlayID++], m_posX, m_posY,bulletWidth * scale,bulletHeight * scale, i);
        if (mPlayID == 4) mPlayID = 0;
    }

    // 更新子弹数据
    public void updateBullet() {
        if (mFacus) {
            m_posY -= BULLET_STEP_Y; // 子弹向上移动
        }
    }

}
