package Interfaces;

import Model.Peliculas;
import Model.ViewModel.PeliculasViewModel;

import java.sql.SQLException;
import java.util.List;

public interface iPeliculasVistas {
    public PeliculasViewModel select(int id) throws SQLException;
    public List<PeliculasViewModel> selectAll() throws SQLException;
    public void insert(Peliculas peliculas) throws SQLException;
    public boolean edit(Peliculas peliculas) throws SQLException;
    public boolean delete(int id) throws SQLException;
}
