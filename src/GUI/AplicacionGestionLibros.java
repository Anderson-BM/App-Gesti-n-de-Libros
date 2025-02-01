package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPanel;


public class AplicacionGestionLibros {

	private JFrame frame;
	private JTable table;
	private JTextField textAutor,textLibro, textPrecio,textCodigo,textBorrarEvento,textBuscarEvento;
//-------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AplicacionGestionLibros window = new AplicacionGestionLibros();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//-------------------------------------------------------------------------------------------
	public AplicacionGestionLibros() {
		initialize();
		
	}
	//-------------------------------------------------------------------------------------------
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(180, 174, 208));
		frame.setBounds(100, 100, 1238, 753);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textLibro = new JTextField();
		textLibro.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		textLibro.setBounds(132, 171, 188, 37);
		frame.getContentPane().add(textLibro);
		textLibro.setColumns(10);
		//-------------------------------------------------------------------------------------------	
		DefaultTableModel modo = new DefaultTableModel(			
				
				new Object[][] {,},
				
				new String [] {"codigo","titulo","autor","precio"});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		scrollPane.setBounds(682, 90, 532, 561);
		frame.getContentPane().add(scrollPane);
		table = new JTable(modo);
		scrollPane.setViewportView(table);
		
		JButton btnMostrarTodo = new JButton("Mostrar Libros");
		btnMostrarTodo.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		btnMostrarTodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				
				 try {
	                    Class.forName("com.mysql.cj.jdbc.Driver");
	                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/GestionLibros", "root", "23abm");

	                    Statement statement = con.createStatement();
	                    modo.setRowCount(0);

	                    ResultSet resultset = statement.executeQuery("SELECT codigo, titulo, autor, precio FROM libros");

	                    while (resultset.next()) {
	                        modo.addRow(new Object[]{
	                            resultset.getInt("codigo"),
	                            resultset.getString("titulo"),
	                            resultset.getString("autor"),
	                            resultset.getDouble("precio")
	                        });
	                    }

	                    con.close();
	                } catch (ClassNotFoundException e1) {
	                    e1.printStackTrace();
	                } catch (SQLException e1) {
	                    e1.printStackTrace();
	                }
	            }		
		});
		btnMostrarTodo.setForeground(Color.WHITE);
		btnMostrarTodo.setBackground(new Color(255, 128, 128));
		btnMostrarTodo.setBounds(1094, 661, 120, 45);
		frame.getContentPane().add(btnMostrarTodo);
		
		textAutor = new JTextField();
		textAutor.setColumns(10);
		textAutor.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		textAutor.setBounds(132, 248, 188, 37);
		frame.getContentPane().add(textAutor);
		
		textPrecio = new JTextField();
		textPrecio.setColumns(10);
		textPrecio.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		textPrecio.setBounds(132, 318, 188, 37);
		frame.getContentPane().add(textPrecio);
		
		textCodigo = new JTextField();
		textCodigo.setColumns(10);
		textCodigo.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		textCodigo.setBounds(132, 101, 188, 37);
		frame.getContentPane().add(textCodigo);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		panel_3.setBackground(new Color(180, 174, 208));
		panel_3.setBounds(10, 0, 1204, 80);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("LIBROS REGISTRADOS");
		lblNewLabel_2.setBounds(825, 17, 288, 46);
		panel_3.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		JLabel lblNewLabel_2_1 = new JLabel("GESTION DE LIBROS");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_2_1.setBounds(24, 17, 288, 46);
		panel_3.add(lblNewLabel_2_1);
		
		JPanel panelAgregar = new JPanel();
		panelAgregar.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		panelAgregar.setBackground(new Color(0, 128, 64));
		panelAgregar.setBounds(10, 88, 326, 618);
		frame.getContentPane().add(panelAgregar);
		panelAgregar.setLayout(null);
		
		JButton btnAgregar = new JButton("Agregar Libro");
		btnAgregar.setBounds(20, 294, 296, 49);
		panelAgregar.add(btnAgregar);
		btnAgregar.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		btnAgregar.setBackground(new Color(0, 102, 0));
		btnAgregar.setForeground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(AplicacionGestionLibros.class.getResource("/IMG/leer (1).png")));
		lblNewLabel_1_1.setBounds(20, 353, 296, 255);
		panelAgregar.add(lblNewLabel_1_1);
		
		JLabel lblTelefono = new JLabel("Precio:");
		lblTelefono.setBounds(10, 222, 113, 45);
		panelAgregar.add(lblTelefono);
		lblTelefono.setForeground(Color.WHITE);
		lblTelefono.setFont(new Font("Verdana", Font.BOLD, 20));
		
		JLabel lblApellido = new JLabel("Autor:");
		lblApellido.setBounds(10, 153, 104, 45);
		panelAgregar.add(lblApellido);
		lblApellido.setForeground(Color.WHITE);
		lblApellido.setFont(new Font("Verdana", Font.BOLD, 20));
		
		JLabel lblNombre = new JLabel("Titulo:");
		lblNombre.setBounds(10, 74, 104, 53);
		panelAgregar.add(lblNombre);
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Verdana", Font.BOLD, 20));
		
		JLabel lblEvento = new JLabel("Codigo:");
		lblEvento.setBounds(10, 10, 104, 45);
		panelAgregar.add(lblEvento);
		lblEvento.setForeground(Color.WHITE);
		lblEvento.setFont(new Font("Verdana", Font.BOLD, 20));
		
		JPanel panelBuscar = new JPanel();
		panelBuscar.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		panelBuscar.setBackground(new Color(0, 0, 160));
		panelBuscar.setBounds(347, 88, 327, 197);
		frame.getContentPane().add(panelBuscar);
		panelBuscar.setLayout(null);
		
		JButton btnNewButton_3 = new JButton("Buscar por Codigo");
		btnNewButton_3.setBounds(10, 138, 120, 49);
		panelBuscar.add(btnNewButton_3);
		btnNewButton_3.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/GestionLibros","root","23abm");
					
					Statement statement=con.createStatement();
					
					String id = textBuscarEvento.getText();
					 modo.setRowCount(0);
					
					ResultSet resultset = statement.executeQuery("select codigo, titulo, autor, precio from libros where codigo= " +id);

                       if(resultset.next()) {
						
						modo.addRow(new Object []  {resultset.getInt("codigo"), resultset.getString("titulo"), resultset.getString("autor"),resultset.getString("precio")});
					}
					con.close();
				
				}catch (ClassNotFoundException e1) {
					e1.printStackTrace();
					
				
				}catch (SQLException e1) {
					e1.printStackTrace();	}
			
				textBuscarEvento.setText("");
				
				   boolean usuarioEncontrado = true; 
			        
			        if (usuarioEncontrado) {
			            JOptionPane.showMessageDialog(null, "Libro encontrado");
			        } else {
			            JOptionPane.showMessageDialog(null, "El Libro no Existe");
			        }
			}
		});
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setBackground(new Color(0, 128, 255));
		
		textBuscarEvento = new JTextField();
		textBuscarEvento.setBounds(152, 138, 165, 49);
		panelBuscar.add(textBuscarEvento);
		textBuscarEvento.setBackground(Color.WHITE);
		textBuscarEvento.setColumns(10);
		textBuscarEvento.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(117, 10, 127, 119);
		panelBuscar.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(AplicacionGestionLibros.class.getResource("/IMG/pila-de-libros.png")));
		
		JPanel panelEliminar = new JPanel();
		panelEliminar.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		panelEliminar.setBackground(new Color(128, 64, 64));
		panelEliminar.setBounds(347, 295, 327, 214);
		frame.getContentPane().add(panelEliminar);
		panelEliminar.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("Borrar por Codigo");
		btnNewButton_2.setBounds(10, 151, 120, 53);
		panelEliminar.add(btnNewButton_2);
		btnNewButton_2.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(255, 0, 0));
		
		textBorrarEvento = new JTextField();
		textBorrarEvento.setBounds(150, 152, 167, 52);
		panelEliminar.add(textBorrarEvento);
		textBorrarEvento.setBackground(Color.WHITE);
		textBorrarEvento.setColumns(10);
		textBorrarEvento.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		
		JLabel lblNewLabel_1_2 = new JLabel("");
		lblNewLabel_1_2.setIcon(new ImageIcon(AplicacionGestionLibros.class.getResource("/IMG/borrar-cuenta.png")));
		lblNewLabel_1_2.setBounds(88, 22, 127, 119);
		panelEliminar.add(lblNewLabel_1_2);
		
		JPanel panelModificar = new JPanel();
		panelModificar.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		panelModificar.setBackground(new Color(255, 128, 192));
		panelModificar.setBounds(347, 519, 327, 187);
		frame.getContentPane().add(panelModificar);
		panelModificar.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Modificar Libro\r\n");
		btnNewButton_1.setBounds(10, 132, 120, 45);
		panelModificar.add(btnNewButton_1);
		btnNewButton_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(255, 128, 192));
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(140, 104, 77, 73);
		panelModificar.add(lblNewLabel_3);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Administrador\\Downloads\\usuario (1).png"));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		panel_4.setBackground(new Color(255, 128, 128));
		panel_4.setBounds(682, 661, 396, 45);
		frame.getContentPane().add(panel_4);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                  try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/GestionLibros","root","23abm");
					
					Statement statement=con.createStatement();
					
					String id = textCodigo.getText();
					 
					statement.executeUpdate("update usuarios set titulo='LIBRO CADUCADO'  where codigo="+id);
					con.close();
					
				}catch (ClassNotFoundException e1) {
					e1.printStackTrace();
					
				
				}catch (SQLException e1) {
					e1.printStackTrace();
					
				}				
				
				textLibro.setText("");
				
				
				   boolean usuarioAgregadoConExito = true; // Cambia esto a tu lógica real
			        
			        if (usuarioAgregadoConExito) {
			            JOptionPane.showMessageDialog(null, "Libro Modificado");
			        } else {
			            JOptionPane.showMessageDialog(null, "Error al modficar Libro.");
			        }
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/GestionLibros","root","23abm");
					
					Statement statement=con.createStatement();
					
					String codigo = textBorrarEvento.getText();
					 
					statement.executeUpdate("delete from libros where codigo="+codigo);
					con.close();
					
					
				}catch (ClassNotFoundException e1) {
					e1.printStackTrace();
					
				
				}catch (SQLException e1) {
					e1.printStackTrace();
	            }
				
				textLibro.setText("");
				
				   boolean usuarioAgregadoConExito = true; // Cambia esto a tu lógica real
			        
			        if (usuarioAgregadoConExito) {
			            JOptionPane.showMessageDialog(null, "Libro Eliminado");
			        } else {
			            JOptionPane.showMessageDialog(null, "Error al eliminar Libro.");
			        }
				
			}
		});
		btnAgregar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				
			 try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/GestionLibroS", "root", "23abm");
		            Statement statement = con.createStatement();

		            String codigo = textCodigo.getText();
		            String titulo = textLibro.getText();
		            String autor = textAutor.getText();
		             String   precio = textPrecio.getText();

		            // Construcción correcta de la consulta SQL
		            String query = "INSERT INTO libros (codigo, titulo, autor, precio) VALUES ('" +
		            		codigo + "',  '" + titulo + "', '" + autor + "', '" + precio + "')";
		            
		            // Ejecutar la consulta de inserción
		            statement.executeUpdate(query);

		            con.close();

		            // Mostrar mensaje de éxito
		            JOptionPane.showMessageDialog(null, "Libro agregado con éxito.");

		            // Limpiar los campos de texto nunca olvidar
		            textCodigo.setText("");
		            textLibro.setText("");
		            textAutor.setText("");
		            textPrecio.setText("");
		            
		        } catch (ClassNotFoundException e1) {
		            e1.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Error al cargar el driver de la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
		        } catch (SQLException e1) {
		            e1.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Error al interactuar con la base de datos: " + e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		        }
		    }
		});
	}
}

