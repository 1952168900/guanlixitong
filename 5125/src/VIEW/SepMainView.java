package VIEW;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import VIEW.SEPVIEW.DeleteSicView;
import VIEW.SEPVIEW.AddSchView;
import VIEW.SEPVIEW.AddSicView;
import VIEW.SEPVIEW.DeleteSchView;
import VIEW.SEPVIEW.SelectPerView;
import VIEW.SEPVIEW.SelectSchView;
import VIEW.SEPVIEW.SelectSicView;
import VIEW.SEPVIEW.UpdatePerView;
import VIEW.SEPVIEW.UpdateSchView;

public class SepMainView {
	JFrame jFrame=new JFrame("出租服务管理系统(服务提供者)");    
	JPanel jPanel=new JPanel(null);
    JMenuBar mb=new JMenuBar();
    JMenu per=new JMenu("个人信息管理");
    JMenu sch=new JMenu("时间表信息管理");
    JMenu sic=new JMenu("签订合同信息管理");

    JMenuItem per_update=new JMenuItem("修改个人信息");
    JMenuItem per_select=new JMenuItem("查找个人信息");
    JMenuItem sch_add=new JMenuItem("增加时间安排表");
    JMenuItem sch_delete=new JMenuItem("删除时间安排表");
    JMenuItem sch_update=new JMenuItem("修改时间安排表信息");
    JMenuItem sch_select=new JMenuItem("查找时间安排表信息");
    JMenuItem sic_add=new JMenuItem("增加签订合同");
    JMenuItem sic_delete=new JMenuItem("删除签订合同");
    JMenuItem sic_select=new JMenuItem("查找已签订的合同信息");

    public void init(){
    	jFrame.setLocationRelativeTo(null);
    	per.add(per_update);
        per.add(per_select);
        sch.add(sch_add);
        sch.add(sch_delete);
        sch.add(sch_update);
        sch.add(sch_select);
        sic.add(sic_add);
        sic.add(sic_delete);
        sic.add(sic_select);
        mb.add(per);
        mb.add(sch);
        mb.add(sic);
        jFrame.setJMenuBar(mb);
        /*
         * 增加
         */
        ActionListener sic_addListener=e -> {
            try {
                new AddSicView().init();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        };
        ActionListener sch_addListener=e -> {
            try {
                new AddSchView().init();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        };
        /**
         * 删除
         */
        
        ActionListener sic_deleteListener=e -> {
            try {
                new DeleteSicView().init();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        };
        ActionListener sch_deleteListener=e -> {
            try {
                new DeleteSchView().init();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        };
        /**
         * 修改
         */
        ActionListener per_updateListener=e -> {
            try {
                new UpdatePerView().init();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        };
        ActionListener sch_updateListener=e -> {
            try {
                new UpdateSchView().init();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        };

        /**
         * 查看
         */
        ActionListener per_selectListener=e -> {
            try {
                new SelectPerView().init();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        };
        ActionListener sch_selectListener=e -> {
            try {
                new SelectSchView().init();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        };
        ActionListener sic_selectListener=e -> {
            try {
                new SelectSicView().init();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        };

        
        sic_add.addActionListener(sic_addListener);
        sic_select.addActionListener(sic_selectListener);
        sic_delete.addActionListener(sic_deleteListener);
        per_update.addActionListener(per_updateListener);       
        per_select.addActionListener(per_selectListener);
        sch_add.addActionListener(sch_addListener);
        sch_delete.addActionListener(sch_deleteListener);
        sch_select.addActionListener(sch_selectListener);
        sch_update.addActionListener(sch_updateListener);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.pack();
    }
}
