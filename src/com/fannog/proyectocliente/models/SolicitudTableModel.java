package com.fannog.proyectocliente.models;

import com.fannog.proyectoservidor.entities.Solicitud;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class SolicitudTableModel extends AbstractTableModel {

    private static final String[] COLUMNS = {"ID", "Estudiante", "Tipo", "Estado"};

    public static final int COL_OBJ = -1;
    private static final int COL_ID = 0;
    private static final int COL_ESTUDIANTE = 1;
    private static final int COL_TIPO = 2;
    private static final int COL_ESTADO = 3;

    private List<Solicitud> solicitudes;

    public SolicitudTableModel(List<Solicitud> solicitudes) {
        this.solicitudes = solicitudes;
    }

    @Override
    public String getColumnName(int column) {
        return COLUMNS[column];
    }

    @Override
    public int getRowCount() {
        return solicitudes.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMNS.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Solicitud solicitud = solicitudes.get(rowIndex);

        switch (columnIndex) {
            case COL_OBJ:
                return solicitud;
            case COL_ID:
                return solicitud.getId();
            case COL_ESTUDIANTE:
                return solicitud.getEstudiante().getNombreUsuario();
            case COL_TIPO:
                return solicitud.getTipo().getNombre();
            case COL_ESTADO:
                return solicitud.getEstado().getNombre();
            default:
                return null;
        }
    }

}
