package VIEW;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import VIEW.CUSVIEW.AddPrjView;
import VIEW.CUSVIEW.AddSicView;
import VIEW.CUSVIEW.DeletePrjView;
import VIEW.CUSVIEW.DeleteSicView;
import VIEW.CUSVIEW.SelectPerView;
import VIEW.CUSVIEW.SelectPrjView;
import VIEW.CUSVIEW.SelectSicView;
import VIEW.CUSVIEW.UpdatePerView;
import VIEW.CUSVIEW.UpdatePrjView;
import VIEW.CUSVIEW.SelectSepView;

public class CusMainView {
	JFrame jFrame=new JFrame("出租服务管理系统(客户)");    
	JPanel jPanel=new JPanel(null);
    JMenuBar mb=new JMenuBar();
    JMenu per=new JMenu("个人信息管理");
    JMenu prj=new JMenu("项目信息管理");
    JMenu sic=new JMenu("签订合同信息管理");

    JMenuItem per_update=new JMenuItem("修改个人信息");
    JMenuItem per_select=new JMenuItem("查找个人信息");
    JMenuItem prj_add=new JMenuItem("增加项目");
    JMenuItem prj_delete=new JMenuItem("删除项目");
    JMenuItem prj_update=new JMenuItem("修改项目信息");
    JMenuItem prj_select=new JMenuItem("查找项目信息");
    JMenuItem sep_select=new JMenuItem("根据种类查找服务提供者信息");
    JMenuItem sic_add=new JMenuItem("增加签订合同");
    JMenuItem sic_delete=new JMenuItem("删除签订合同");
    JMenuItem sic_select=new JMenuItem("查找已签订的合同信息");

    public void init(){
    	
    	jFrame.setLocationRelativeTo(null);
    	per.add(per_update);
        per.add(per_select);
        prj.add(prj_add);
        prj.add(prj_delete);
        prj.add(prj_update);
        prj.add(prj_select);
        sic.add(sep_select);
        sic.add(sic_add);
        sic.add(sic_delete);
        sic.add(sic_select);
        mb.add(per);
        mb.add(prj);
        mb.add(sic);
        jFrame.setJMenuBar(mb);
        /**
         * 增加
         */
        ActionListener prj_addListener=e -> {
            try {
                new AddPrjView().init();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        };
        ActionListener sic_addListener=e -> {
            try {
                new AddSicView().init();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        };
        /**
         * 删除
         */
        
        ActionListener prj_deleteListener=e -> {
            try {
                new DeletePrjView().init();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        };
        ActionListener sic_deleteListener=e -> {
            try {
                new DeleteSicView().init();
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
        ActionListener prj_updateListener=e -> {
            try {
                new UpdatePrjView().init();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        };
        /**
         * 查找
         */
        ActionListener sep_selectListener=e -> {
            try {
                new SelectSepView().init();
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
        ActionListener prj_selectListener=e -> {
            try {
                new SelectPrjView().init();
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

        prj_add.addActionListener(prj_addListener);
        sic_add.addActionListener(sic_addListener);
        prj_delete.addActionListener(prj_deleteListener);
        sic_delete.addActionListener(sic_deleteListener);
        per_update.addActionListener(per_updateListener);
        prj_update.addActionListener(prj_updateListener);
        sep_select.addActionListener(sep_selectListener);
        per_select.addActionListener(per_selectListener);
        prj_select.addActionListener(prj_selectListener);
        sic_select.addActionListener(sic_selectListener);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.pack();
    }
}
