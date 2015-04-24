/* 程序运行时自动产生1-100的随机数 
 * 接受用户键盘输入数据并给出指示信息 
 * 直至猜对，游戏者猜对后，显示猜对次数 
 * 并且供计时功能  
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.*;
public class GuessNum extends javax.swing.JFrame {

 {
  //Set Look & Feel
  try { //设置窗口外观为windows外观
   javax.swing.UIManager.setLookAndFeel
("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
  } catch(Exception e) {
   e.printStackTrace();
  }
 }

 private JLabel jLabel1;
 private JTextField jTextField1;
 private JButton jButton1; 
 private JButton jButton2;
 private int number=0;
 private int counter=0;
 long startTime = System.currentTimeMillis();
 long endTime;
 /**
 * Auto-generated main method to display this JFrame
 */
 public static void main(String[] args) {
  GuessNum inst = new GuessNum();
  inst.setVisible(true); //显示窗口
 }
 
/**
 *新建一个随机数产生器，然后生成一个1到100之间的整数
*/
 public GuessNum() {
  super();
  initGUI();
  Random random = new Random();
  number = random.nextInt(100); //产生一个1-100间的随机数
 }
 
	/**
  *初始化窗口组件
  */
 private void initGUI() {
  try {
   setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);//窗口关闭时销毁窗口
   getContentPane().setLayout(null);//设置窗口布局为绝对布局
   {
    jLabel1 = new JLabel();
    getContentPane().add(jLabel1);
    jLabel1.setText("<html>欢迎进入有趣的猜数字游戏；<br><br><br>"+
      "  1到100之间的整数，你猜是什么？快来猜猜看(^.^)<br><br><br>"+
            "请输入你想猜的数：</html>");
    jLabel1.setBounds(45, 0, 420, 150);//设置标签位置
   }
   {
    jTextField1 = new JTextField();
    getContentPane().add(jTextField1);
    jTextField1.setBounds(42, 168, 112, 28);//输入窗口大小
    jTextField1.addKeyListener(new KeyAdapter(){//文本框添加键盘按键监听-监听回车键
     public void keyPressed(KeyEvent evt) {
      jTextField1KeyPressed(evt);
     }
    });
   }
   {
    jButton1 = new JButton();
    getContentPane().add(jButton1);
    jButton1.setText("确定");
    jButton1.setBounds(182, 168, 77, 28);//确定按钮
    jButton1.addActionListener(new ActionListener(){//按钮添加监听
     public void actionPerformed(ActionEvent evt) {
      jButton1ActionPerformed(evt);//按钮被点击时 执行该方法
     }
    });
   }
   {
    jButton2 = new JButton();
    getContentPane().add(jButton2);
    jButton2.setText("重新开始");
    jButton2.setBounds(280, 168, 91, 28);//设置重新开始按钮
    jButton2.addActionListener(new ActionListener() {
     public void actionPerformed(ActionEvent evt) {
      jButton2ActionPerformed(evt);
     }
    });
   }
   pack();
   this.setSize(450, 280);// 设置窗口大小
   setLocationRelativeTo(null);// 设置窗口在显示器居中显示
  } catch (Exception e) {
   e.printStackTrace();
  }
 }
 
/**
  * “确定”按钮事件监听
  * @param evt
  */
 private void jButton1ActionPerformed(ActionEvent evt) {
  int guess=0; // 记录玩家所猜测的数字
  counter++; // 计数器增加一

	// try，catch的异常管理。
  try {

  // 获取玩家的输入
   guess=Integer.parseInt(jTextField1.getText());
  } catch (Exception e) {

  // 如果玩家不是输入一个合法的整数，则让他重新输入。
   JOptionPane.showMessageDialog(null, "数字不合法，请输入一个1-100之间的整数!");
 //显示一个对话框
   jTextField1.setText("");//清空文本框内容
   jTextField1.requestFocus();//文本框获取输入焦点
   return ;
  }

// 对玩家的输入进行判断。
  if (guess > number){
   JOptionPane.showMessageDialog(null, "猜的有点大了⊙﹏⊙!，再小一点吧!");
   jTextField1.setText("");
   jTextField1.requestFocus();
   return ;
  }
  if (guess < number){
   JOptionPane.showMessageDialog(null, "猜的一有点小了⊙﹏⊙!，再大一点吧!");
   jTextField1.setText("");
   jTextField1.requestFocus();
   return ;
  } 
  if (guess == number) {
   endTime=System.currentTimeMillis();

   // 判断成绩。
   switch (counter) {
    case 1: JOptionPane.showMessageDialog(null,"好厉害，真棒！！ ?(′▽｀)");
    break;
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case 7: JOptionPane.showMessageDialog(null,"这么快就猜对了，好厉害哦！  ↖(^ω^)↗");
    break;
    default:JOptionPane.showMessageDialog(null,"猜了半天才猜出来，小同志，尚须努力啊！  ╮(╯_╰)╭");
    break;
   }
   JOptionPane.showMessageDialog(null,"您总共猜了"+counter+"次   共花了"+(endTime-
startTime)/1000+"秒的时间答对正确答案!");
  }
  jTextField1.setText("");
  jTextField1.requestFocus();
 }
 
 private void jButton2ActionPerformed(ActionEvent evt) {// 重新开始
  Random random = new Random(); // 重新生成随机数
  number = random.nextInt(100); // 产生一个1-100间的随机数
  counter=0; // 记录玩家猜测的次数
  jTextField1.setText("");
  startTime = System.currentTimeMillis();
 }
 
 private void jTextField1KeyPressed(KeyEvent evt) {
  // 监听文本框回车
  if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
   jButton1.doClick();// 文本框按回车键 执行“确定”按钮的事件
  }
 }
}
