package view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.ScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class HienThiCayThuMuc extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtPath;
	private JTree jTree;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HienThiCayThuMuc frame = new HienThiCayThuMuc();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private void listFileAll(String path) {
	    // Tạo một đối tượng File từ đường dẫn được chọn
	    File myFile = new File(path);

	    // Tạo nút gốc cho cây thư mục với tên của thư mục được chọn
	    DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode(myFile.getName());

	    // Duyệt qua tất cả các tệp tin và thư mục trong thư mục được chọn
	    for (File f : myFile.listFiles()) {
	        // Tạo nút con cho mỗi tệp tin hoặc thư mục
	        DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(f.getName());

	        // Thêm nút con vào nút gốc
	        rootNode.add(childNode);

	        // Nếu là thư mục, thêm các nút con bổ sung cho thư mục đó
	        if (f.isDirectory()) {
	            addSubNodes(childNode, f);
	        }
	    }

	    // Tạo một mô hình cây mới với nút gốc và đặt nó cho JTree
	    DefaultTreeModel defaultTreeModel = new DefaultTreeModel(rootNode);
	    jTree.setModel(defaultTreeModel);
	}

	private void addSubNodes(DefaultMutableTreeNode parentNode, File parentFile) {
	    // Duyệt qua tất cả các tệp tin và thư mục trong thư mục cha
	    for (File f : parentFile.listFiles()) {
	        // Tạo nút con cho mỗi tệp tin hoặc thư mục
	        DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(f.getName());

	        // Thêm nút con vào nút cha
	        parentNode.add(childNode);

	        // Nếu là thư mục, đệ quy thêm các nút con bổ sung cho thư mục đó
	        if (f.isDirectory()) {
	            addSubNodes(childNode, f);
	        }
	    }
	}
	public HienThiCayThuMuc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 673, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Path:");
		lblNewLabel.setBounds(100, 23, 67, 21);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		contentPane.add(lblNewLabel);
		txtPath = new JTextField();
		txtPath.setBounds(193, 17, 309, 35);
		contentPane.add(txtPath);
		txtPath.setColumns(10);
		
		JButton btnOpenPath = new JButton("Open Folder");
		btnOpenPath.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser filechooser = new JFileChooser();
			    filechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			    
			    int result = filechooser.showOpenDialog(null);
			    if(result == JFileChooser.APPROVE_OPTION){
			        String path = filechooser.getSelectedFile().getAbsolutePath();
			        txtPath.setText(path);
			        listFileAll(path);
			}
			}
		});
		btnOpenPath.setBounds(537, 16, 99, 36);
		contentPane.add(btnOpenPath);
		
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBounds(10, 62, 492, 244);
		contentPane.add(scrollPane);
		
		jTree = new JTree();
		jTree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Files") {
				{
				}
			}
		));
		jTree.setBounds(58, 94, 70, 64);
		scrollPane.add(jTree);
	}
}
