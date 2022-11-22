package Interfaces;

import Model.Fotos;
import Model.ViewModel.FotosViewModel;

import java.sql.SQLException;
import java.util.List;

public interface iFotos {
    public FotosViewModel select(int id) throws SQLException;
    public List<FotosViewModel> selectAll() throws SQLException;
    public void insert(Fotos fotos) throws SQLException;
    public boolean edit(Fotos fotos) throws SQLException;
    public boolean delete(int id) throws SQLException;
    public boolean show(int idfoto, int idpelicula) throws SQLException;
}
