
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Task;
import util.ConnectionFactory;

/**
 *
 * @author Jefferson Klamas Marzani (jkm)
 */
public class TaskController {

    public void save(Task task) {
        /**
         * Metodo para Salvar as tarefas no Banco de Dados.
         */

        String sql = "INSERT INTO tasks (idProject, "
                + "name, "
                + "description,"
                + "completed, "
                + "notes, "
                + "deadline, "
                + "createDat, "
                + "updateDat) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.isIsCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new Date(task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreateDat().getTime()));
            statement.setDate(8, new Date(task.getUpdateDat().getTime()));
            statement.execute();

        } catch (Exception ex) {
            throw new RuntimeException("Erro ao salvar a tarefa "
                    + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }

    public void update(Task task) {
        /**
         * Metodo para Alterar as tarefas no Banco de Dados.
         */

        String sql = "UPDATE tasks SET "
                + "idProject = ?, "
                + "name = ?, "
                + "description = ?, "
                + "completed = ?, "
                + "notes = ?,"
                + "deadline = ?, "
                + "createDat = ?,"
                + "updateDat = ? "
                + "WHERE id = ?";

        Connection connection = null;
        PreparedStatement statement = null;
        /**
         * Establishing the connection with the database, Preparing the query,
         * Setting the Statement values and Executing the Query. 
         */
        try {
            // Estabelecendo a conexao com o banco de dados
            // Establishing the connection to the database.
            connection = ConnectionFactory.getConnection();
            // Preparando a query
            // Preparing the query
            statement = connection.prepareStatement(sql);
            // Setando os valores do Statement
            // Setting the values of the Statement
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.isIsCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new Date(task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreateDat().getTime()));
            statement.setDate(8, new Date(task.getUpdateDat().getTime()));
            statement.setInt(9, task.getId());
            // Executanco a Query
            // Executing the Query
            statement.execute();

        } catch (Exception ex) {
            throw new RuntimeException("Erro ao altualizar a tarefa!!! "
                    + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }

    }

    public void removeById(int taskId) {
        /**
         * Metodo para Deletar tarefas no Banco de Dados.
         */
        String sql = "DELETE FROM tasks WHERE id = ?";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
                            
            connection = ConnectionFactory.getConnection(); // Solicitando Conexao BD
            statement = connection.prepareStatement(sql); // Prepara o SQL
            statement.setInt(1, taskId); // Setou o ID da tarefa requisitada no Paramentro
            statement.execute(); // Executando no BD

        } catch (Exception ex) {

            throw new RuntimeException("Erro ao deletar a tarefa..."
                    + ex.getMessage(), ex);

        } finally {

            ConnectionFactory.closeConnection(connection, statement); // Fechando a Conexao com o BD.

        }
    }

    public List<Task> getAll(int idProject) {
        /**
         * Metodo para Selecionar todas tarefas de um Projeto no Banco de Dados.
         */

        String sql = "SELECT * FROM tasks WHERE idProject = ?";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        // Lista de Tarefas que sera devolvida quando a chamada do metodo ocorrer.
        
        List<Task> tasks = new ArrayList<Task>();

        try {
            // Criando a conexao com o banco de dados
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            // Setando o valor que corresponde ao filtro de busca
            statement.setInt(1, idProject);
            // Valor retornado pel execuçao da Query
            resultSet = statement.executeQuery();
            // enquanto houverem valores a serem percorridos no resumeSet
            while (resultSet.next()) {

                Task task = new Task();
                task.setId(resultSet.getInt("id"));
                task.setIdProject(resultSet.getInt("idProject"));
                task.setName(resultSet.getString("name"));
                task.setDescription(resultSet.getString("description"));
                task.setIsCompleted(resultSet.getBoolean("completed"));
                task.setNotes(resultSet.getString("notes"));
                task.setDeadline(resultSet.getDate("deadline"));
                task.setCreateDat(resultSet.getDate("createDat"));
                task.setUpdateDat(resultSet.getDate("updateDat"));

                tasks.add(task);
            }

        } catch (Exception ex) {

            throw new RuntimeException("Erro ao inserir a tarefa... "
                    + ex.getMessage(), ex);

        } finally {

            ConnectionFactory.closeConnection(connection, statement, resultSet);

        }

        /**
         * Lista de tarefas que foi criada e carregada do Banco de Dados.
         */
        return tasks;
    }
}
