/*package Interfaz.Form;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BusinessLogic.CDBLHormiga;
import DataAccess.CDDataHelper;
import DataAccess.DAO.CDDAOHormiga;
import Interfaz.CDIAStyle;
import Interfaz.Customer.CDButton;
import Interfaz.Customer.CDButton3;
import Interfaz.Customer.CDButton4;
import Interfaz.Customer.CDLabel3;

public class CDPanelCentral extends JPanel {

    private List<String> provincias = new ArrayList<>();
    private DefaultTableModel CDmodel;
    public CDButton3 CDbtnCrear = new CDButton3("Crear Hormiga");
    public CDButton4 CDbtnEliminar = new CDButton4("Eliminar");
    public CDButton4 CDbtnGuardar = new CDButton4("Guardar");

    public CDPanelCentral() {
        // Inicializa el modelo de tabla
        CDmodel = new DefaultTableModel(
                new Object[] { "IdHormiga", "TipoHormiga", "Ubicacion", "Sexo", "GenoAlimento", "IngestaNativa" }, 0) {

            // Hacer las celdas no editables
            @Override
            public boolean isCellEditable(int row, int column) {
                // Hacer las celdas editables solo si la fila no es la primera
                if (row > 0) {
                    return column == 1 || column == 2 || column == 3 || column == 4 || column == 5;
                }
                return false; // La primera fila no es editable
            }
        };

        cargarDatosDesdeDB();
        cargarProvinciasDesdeDB();
        configurarAcciones();

        // Configuración del panel superior
        JPanel CDtopPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        try {
            Image CDlogo = ImageIO.read(CDIAStyle.CDURL_LOGOSF);
            CDlogo = CDlogo.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            CDtopPanel.add(new JLabel(new ImageIcon(CDlogo)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        CDtopPanel.add(new CDLabel3("Hormiguero Virtual               "));
        CDtopPanel.add(CDbtnCrear, FlowLayout.RIGHT);
        add(CDtopPanel, BorderLayout.NORTH);

        // Configuración del panel central para mostrar la tabla
        JPanel CDgridPanel = new JPanel(new BorderLayout());
        JTable table = new JTable(CDmodel);
        JScrollPane CDscrollPane = new JScrollPane(table);
        CDscrollPane.setPreferredSize(new Dimension(550, 200));
        add(CDgridPanel, BorderLayout.CENTER);
        CDgridPanel.add(CDscrollPane, BorderLayout.CENTER);

        // Configuración del panel inferior
        JPanel CDbottomPanel = new JPanel(new GridLayout(3, 2, 50, 10));
        CDButton CDGenoAlimento = new CDButton("GenoAlimento");
        CDButton CDIngestaNativa = new CDButton("Ingesta Nativa");
        CDButton3 CDbtnAlimenGeno = new CDButton3("Alimentar GenoAlimento");
        CDButton3 CDbtnAlimenNat = new CDButton3("Alimentar Ingesta Nativa");

        JPopupMenu CDGenoAlimentoMenu = new JPopupMenu();
        JMenuItem CDX = new JMenuItem("X");
        JMenuItem CDXX = new JMenuItem("XX");
        JMenuItem CDXY = new JMenuItem("XY");

        JPopupMenu CDIngestaNativaMenu = new JPopupMenu();
        JMenuItem CDCar = new JMenuItem("Carnívoro");
        JMenuItem CDHer = new JMenuItem("Herbívoro");
        JMenuItem CDOmn = new JMenuItem("Omnívoro");
        JMenuItem CDIns = new JMenuItem("Insectívoro");

        CDX.addActionListener(e -> CDGenoAlimento.setText(CDX.getText()));
        CDXX.addActionListener(e -> CDGenoAlimento.setText(CDXX.getText()));
        CDXY.addActionListener(e -> CDGenoAlimento.setText(CDXY.getText()));
        CDCar.addActionListener(e -> CDIngestaNativa.setText(CDCar.getText()));
        CDHer.addActionListener(e -> CDIngestaNativa.setText(CDHer.getText()));
        CDOmn.addActionListener(e -> CDIngestaNativa.setText(CDOmn.getText()));
        CDIns.addActionListener(e -> CDIngestaNativa.setText(CDIns.getText()));

        CDGenoAlimentoMenu.add(CDX);
        CDGenoAlimentoMenu.add(CDXX);
        CDGenoAlimentoMenu.add(CDXY);
        CDIngestaNativaMenu.add(CDCar);
        CDIngestaNativaMenu.add(CDHer);
        CDIngestaNativaMenu.add(CDOmn);
        CDIngestaNativaMenu.add(CDIns);

        CDGenoAlimento.addActionListener(e -> {
            CDGenoAlimentoMenu.show(CDGenoAlimento, 0, CDGenoAlimento.getHeight());
        });

        CDIngestaNativa.addActionListener(e -> {
            CDIngestaNativaMenu.show(CDIngestaNativa, 0, CDIngestaNativa.getHeight());
        });

        CDbtnAlimenGeno.addActionListener(e -> {
            int lastRowIndex = CDmodel.getRowCount() - 1;
            if (lastRowIndex >= 0) {
                String genoAlimento = CDGenoAlimento.getText();

                if ("XX".equals(genoAlimento)) {
                    CDmodel.setValueAt("XX", lastRowIndex, 4);
                    String tipoHormiga = Math.random() < 0.5 ? "Larva" : "Reina";
                    CDmodel.setValueAt(tipoHormiga, lastRowIndex, 1);
                    CDmodel.setValueAt("Femenino", lastRowIndex, 3);

                } else if ("XY".equals(genoAlimento)) {
                    CDmodel.setValueAt("XY", lastRowIndex, 4);
                    CDmodel.setValueAt("Soldado", lastRowIndex, 1);
                    CDmodel.setValueAt("Masculino", lastRowIndex, 3);

                } else {
                    CDmodel.setValueAt(genoAlimento, lastRowIndex, 4);
                    CDmodel.setValueAt("Asexual", lastRowIndex, 3);
                    CDmodel.setValueAt("Zángano", lastRowIndex, 1);
                }

                // Asignar una provincia aleatoria
                if (!provincias.isEmpty()) {
                    int randomIndex = (int) (Math.random() * provincias.size());
                    String provinciaAleatoria = provincias.get(randomIndex);
                    CDmodel.setValueAt(provinciaAleatoria, lastRowIndex, 2);
                }
            }
        });

        CDbtnAlimenNat.addActionListener(e -> {
            int lastRowIndex = CDmodel.getRowCount() - 1;
            if (lastRowIndex >= 0) {
                // Actualizar la columna "Ingesta Nativa"
                CDmodel.setValueAt(CDIngestaNativa.getText(), lastRowIndex, 5);
            }
        });

        CDbottomPanel.add(CDGenoAlimento);
        CDbottomPanel.add(CDbtnAlimenGeno);
        CDbottomPanel.add(CDIngestaNativa);
        CDbottomPanel.add(CDbtnAlimenNat);
        CDbottomPanel.add(CDbtnEliminar);
        CDbottomPanel.add(CDbtnGuardar);

        add(CDbottomPanel, BorderLayout.SOUTH);
    }

    private void cargarDatosDesdeDB() {
        String query = "SELECT " +
                "H.IdHormiga, " +
                "CDC1.Nombre AS TipoHormiga, " +
                "CDC2.Nombre AS IngestaNativa, " +
                "CDC3.Nombre AS GenoAlimento, " +
                "CDC4.Nombre AS Sexo, " +
                "U.Provincia AS Ubicacion " +
                "FROM CDHormiga H " +
                "JOIN CDCatalogo CDC1 ON H.IdClgTipoHormiga = CDC1.IdCatalogo " +
                "JOIN CDCatalogo CDC2 ON H.IdClgIngestaNativa = CDC2.IdCatalogo " +
                "JOIN CDCatalogo CDC3 ON H.IdClgGenoAlimento = CDC3.IdCatalogo " +
                "JOIN CDCatalogo CDC4 ON H.IdClgSexo = CDC4.IdCatalogo " +
                "JOIN CDUbicacion U ON H.IdUbicacion = U.IdUbicacion";

        try (Connection conn = CDDataHelper.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Object[] row = new Object[6];
                row[0] = rs.getInt("IdHormiga");
                row[1] = rs.getString("TipoHormiga");
                row[2] = rs.getString("Ubicacion");
                row[3] = rs.getString("Sexo");
                row[4] = rs.getString("GenoAlimento");
                row[5] = rs.getString("IngestaNativa");
                CDmodel.addRow(row);
            }
        } catch (SQLException e) {
            System.err.println("Error al cargar datos desde la base de datos: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void configurarAcciones() {
        CDbtnCrear.addActionListener(e -> {
            // Agregar una nueva fila vacía a la tabla
            CDmodel.addRow(new Object[] { null, null, null, null, null, null });
        });

        // CDbtnEliminar.addActionListener( );

    }

    private void cargarProvinciasDesdeDB() {
        String query = "SELECT DISTINCT Provincia FROM CDUbicacion";

        try (Connection conn = CDDataHelper.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                provincias.add(rs.getString("Provincia"));
            }
        } catch (SQLException e) {
            System.err.println("Error al cargar provincias desde la base de datos: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // private void Eliminar() {
    // try {
    // if (CDIAStyle.showConfirmYesNo("Seguro que desea Eliminar?")) {

    // if (!CDBLHormiga.delete(CDDAOHormiga.CDIdHormiga()))
    // throw new Exception("Error al eliminar...!");
    // loadRow();
    // showRow();
    // showTable();
    // }
    // } catch (Exception e) {
    // CDIAStyle.showMsgError(e.getMessage());
    // }
    // }

    private void loadRow() {
        try {
            cdRowNum = 1;
            cdHormigasDAO = CDBLHormiga.getBy(CDRowNum);
            cdIdRowMax = CDBLHormiga.getRowCount();
        } catch (Exception e) {
            CDIAStyle.showMsg(e.getMessage());
        }
    }

    private void showRow() {
        boolean cdHormigaNull = (cdHormigasDAO == null);
        cdTxtRowNum.setText((cdHormigaNull) ? " " : cdHormigasDAO.cdGetIdHormiga().toString());
        cdLblTotalReg.setText(cdRowNum.toString() + " de " + cdIdRowMax.toString());
    }

}*/


package Interfaz.Form;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BusinessLogic.CDBLHormiga;
import DataAccess.CDDataHelper;
import DataAccess.DAO.CDDAOHormiga;
import DataAccess.DTO.CDDTOHormiga;
import Interfaz.CDIAStyle;
import Interfaz.Customer.CDButton;
import Interfaz.Customer.CDButton3;
import Interfaz.Customer.CDButton4;
import Interfaz.Customer.CDLabel3;

public class CDPanelCentral extends JPanel {

    private List<String> provincias = new ArrayList<>();
    private DefaultTableModel CDmodel;
    public CDButton3 CDbtnCrear = new CDButton3("Crear Hormiga");
    public CDButton4 CDbtnEliminar = new CDButton4("Eliminar");
    public CDButton4 CDbtnGuardar = new CDButton4("Guardar");

    public CDPanelCentral() {
        // Inicializa el modelo de tabla
        CDmodel = new DefaultTableModel(
                new Object[] { "IdHormiga", "TipoHormiga", "Ubicacion", "Sexo", "GenoAlimento", "IngestaNativa" }, 0) {

            // Hacer las celdas no editables
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Las celdas no deben ser editables
            }
        };

        cargarDatosDesdeDB();
        cargarProvinciasDesdeDB();
        configurarAcciones();

        // Configuración del panel superior
        JPanel CDtopPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        try {
            Image CDlogo = ImageIO.read(CDIAStyle.CDURL_LOGOSF);
            CDlogo = CDlogo.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            CDtopPanel.add(new JLabel(new ImageIcon(CDlogo)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        CDtopPanel.add(new CDLabel3("Hormiguero Virtual               "));
        CDtopPanel.add(CDbtnCrear, FlowLayout.RIGHT);
        add(CDtopPanel, BorderLayout.NORTH);

        // Configuración del panel central para mostrar la tabla
        JPanel CDgridPanel = new JPanel(new BorderLayout());
        JTable table = new JTable(CDmodel);
        JScrollPane CDscrollPane = new JScrollPane(table);
        CDscrollPane.setPreferredSize(new Dimension(550, 200));
        add(CDgridPanel, BorderLayout.CENTER);
        CDgridPanel.add(CDscrollPane, BorderLayout.CENTER);

        // Configuración del panel inferior
        JPanel CDbottomPanel = new JPanel(new GridLayout(3, 2, 50, 10));
        CDButton CDGenoAlimento = new CDButton("GenoAlimento");
        CDButton CDIngestaNativa = new CDButton("Ingesta Nativa");
        CDButton3 CDbtnAlimenGeno = new CDButton3("Alimentar GenoAlimento");
        CDButton3 CDbtnAlimenNat = new CDButton3("Alimentar Ingesta Nativa");

        JPopupMenu CDGenoAlimentoMenu = new JPopupMenu();
        JMenuItem CDX = new JMenuItem("X");
        JMenuItem CDXX = new JMenuItem("XX");
        JMenuItem CDXY = new JMenuItem("XY");

        JPopupMenu CDIngestaNativaMenu = new JPopupMenu();
        JMenuItem CDCar = new JMenuItem("Carnívoro");
        JMenuItem CDHer = new JMenuItem("Herbívoro");
        JMenuItem CDOmn = new JMenuItem("Omnívoro");
        JMenuItem CDIns = new JMenuItem("Insectívoro");

        CDX.addActionListener(e -> CDGenoAlimento.setText(CDX.getText()));
        CDXX.addActionListener(e -> CDGenoAlimento.setText(CDXX.getText()));
        CDXY.addActionListener(e -> CDGenoAlimento.setText(CDXY.getText()));
        CDCar.addActionListener(e -> CDIngestaNativa.setText(CDCar.getText()));
        CDHer.addActionListener(e -> CDIngestaNativa.setText(CDHer.getText()));
        CDOmn.addActionListener(e -> CDIngestaNativa.setText(CDOmn.getText()));
        CDIns.addActionListener(e -> CDIngestaNativa.setText(CDIns.getText()));

        CDGenoAlimentoMenu.add(CDX);
        CDGenoAlimentoMenu.add(CDXX);
        CDGenoAlimentoMenu.add(CDXY);
        CDIngestaNativaMenu.add(CDCar);
        CDIngestaNativaMenu.add(CDHer);
        CDIngestaNativaMenu.add(CDOmn);
        CDIngestaNativaMenu.add(CDIns);

        CDGenoAlimento.addActionListener(e -> {
            CDGenoAlimentoMenu.show(CDGenoAlimento, 0, CDGenoAlimento.getHeight());
        });

        CDIngestaNativa.addActionListener(e -> {
            CDIngestaNativaMenu.show(CDIngestaNativa, 0, CDIngestaNativa.getHeight());
        });

        CDbtnCrear.addActionListener(e -> {
            // Agregar una nueva fila vacía a la tabla
            CDmodel.addRow(new Object[] { null, null, null, null, null, null });
        });

        CDbtnAlimenGeno.addActionListener(e -> {
            int lastRowIndex = CDmodel.getRowCount() - 1;
            if (lastRowIndex >= 0) {
                String genoAlimento = CDGenoAlimento.getText();

                if ("XX".equals(genoAlimento)) {
                    CDmodel.setValueAt("XX", lastRowIndex, 4);
                    String tipoHormiga = Math.random() < 0.5 ? "Larva" : "Reina";
                    CDmodel.setValueAt(tipoHormiga, lastRowIndex, 1);
                    CDmodel.setValueAt("Femenino", lastRowIndex, 3);

                } else if ("XY".equals(genoAlimento)) {
                    CDmodel.setValueAt("XY", lastRowIndex, 4);
                    CDmodel.setValueAt("Soldado", lastRowIndex, 1);
                    CDmodel.setValueAt("Masculino", lastRowIndex, 3);
                    CDmodel.setValueAt("Zángano", lastRowIndex, 1);

                } else {
                    CDmodel.setValueAt(genoAlimento, lastRowIndex, 4);
                    CDmodel.setValueAt("Asexual", lastRowIndex, 3);
                }

                // Asignar una provincia aleatoria
                if (!provincias.isEmpty()) {
                    int randomIndex = (int) (Math.random() * provincias.size());
                    String provinciaAleatoria = provincias.get(randomIndex);
                    CDmodel.setValueAt(provinciaAleatoria, lastRowIndex, 2);
                }
            }
        });

        CDbtnAlimenNat.addActionListener(e -> {
            int lastRowIndex = CDmodel.getRowCount() - 1;
            if (lastRowIndex >= 0) {
                // Actualizar la columna "Ingesta Nativa"
                CDmodel.setValueAt(CDIngestaNativa.getText(), lastRowIndex, 5);
            }
        });

        CDbottomPanel.add(CDGenoAlimento);
        CDbottomPanel.add(CDbtnAlimenGeno);
        CDbottomPanel.add(CDIngestaNativa);
        CDbottomPanel.add(CDbtnAlimenNat);
        CDbottomPanel.add(CDbtnEliminar);
        CDbottomPanel.add(CDbtnGuardar);

        add(CDbottomPanel, BorderLayout.SOUTH);
    }

    private void cargarDatosDesdeDB() {
        try (Connection conn = CDDataHelper.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM CDHormiga")) {

            // Limpiar la tabla antes de cargar los datos
            CDmodel.setRowCount(0);

            while (rs.next()) {
                CDmodel.addRow(new Object[] {
                        rs.getInt("IdHormiga"),
                        rs.getString("TipoHormiga"),
                        rs.getString("Ubicacion"),
                        rs.getString("Sexo"),
                        rs.getString("GenoAlimento"),
                        rs.getString("IngestaNativa")
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void cargarProvinciasDesdeDB() {
        String query = "SELECT DISTINCT Provincia FROM CDUbicacion";
        try (Connection conn = CDDataHelper.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                provincias.add(rs.getString("Provincia"));
            }
        } catch (SQLException e) {
            System.err.println("Error al cargar provincias desde la base de datos: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void configurarAcciones() {
        CDbtnGuardar.addActionListener(e -> {
            int respuesta = JOptionPane.showConfirmDialog(this,
                    "¿Está seguro de guardar todo el hormiguero en la base de datos?",
                    "Confirmación de Guardado", JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_OPTION) {
                guardarDatosEnDB();
            }
        });

        CDbtnEliminar.addActionListener(e -> {
            int selectedRow = getSelectedRow();
            if (selectedRow != -1) {
                int respuesta = JOptionPane.showConfirmDialog(this,
                        "¿Está seguro de eliminar la fila seleccionada?",
                        "Confirmación de Eliminación", JOptionPane.YES_NO_OPTION);

                if (respuesta == JOptionPane.YES_OPTION) {
                    eliminarFila(selectedRow);
                }
            } else {
                JOptionPane.showMessageDialog(this, "No se ha seleccionado ninguna fila.");
            }
        });
    }

    private int getSelectedRow() {
        // Implementa la lógica para obtener la fila seleccionada en la tabla
        JTable table = (JTable) ((JScrollPane) getComponent(1)).getViewport().getView();
        return table.getSelectedRow();
    }

    private void eliminarFila(int rowIndex) {
        try (Connection conn = CDDataHelper.getConnection();
                PreparedStatement stmt = conn.prepareStatement("DELETE FROM CDHormiga WHERE IdHormiga = ?")) {

            int idHormiga = (int) CDmodel.getValueAt(rowIndex, 0);
            stmt.setInt(1, idHormiga);
            stmt.executeUpdate();

            // Eliminar la fila del modelo de la tabla
            CDmodel.removeRow(rowIndex);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    CDBLHormiga CDBLHormiga;
    CDDTOHormiga CDDTOHormiga;
    private void guardarDatosEnDB() {
        try (Connection conn = CDDataHelper.getConnection()) {
            conn.setAutoCommit(false);

            // Primero, eliminar todas las hormigas existentes en la base de datos
            try (PreparedStatement deleteStmt = conn.prepareStatement("DELETE FROM CDHormiga")) {
                deleteStmt.executeUpdate();
            }

            // Luego, insertar todos los datos de la tabla en la base de datos
            try (PreparedStatement insertStmt = conn.prepareStatement(
                    "INSERT INTO CDHormiga (IdHormiga, TipoHormiga, Ubicacion, Sexo, GenoAlimento, IngestaNativa) VALUES (?, ?, ?, ?, ?, ?)")) {

                for (int i = 0; i < CDmodel.getRowCount(); i++) {
                    insertStmt.setObject(1, CDmodel.getValueAt(i, 0));
                    insertStmt.setObject(2, CDmodel.getValueAt(i, 1));
                    insertStmt.setObject(3, CDmodel.getValueAt(i, 2));
                    insertStmt.setObject(4, CDmodel.getValueAt(i, 3));
                    insertStmt.setObject(5, CDmodel.getValueAt(i, 4));
                    insertStmt.setObject(6, CDmodel.getValueAt(i, 5));
                    insertStmt.addBatch();
                }

                insertStmt.executeBatch();
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                throw e;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            CDBLHormiga.add(CDDTOHormiga);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
