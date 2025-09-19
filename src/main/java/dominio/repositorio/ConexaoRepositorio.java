package dominio.repositorio;

import lombok.Setter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public enum ConexaoRepositorio {
    INSTANCIA;


    @Setter
    private String url;
    @Setter
    private String usuario;
    @Setter
    private String senha;


    public Connection abrir() throws SQLException {
        return DriverManager.getConnection(
            url,
            usuario,
            senha
        );
    }
}
