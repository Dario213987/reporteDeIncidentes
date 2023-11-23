import Entidades.Cliente;
import Logica.DAOGenericoHibernate;

public class Main {
    public static void main(String[] args){
        DAOGenericoHibernate<Cliente> clienteDAOGenericoHibernate = new DAOGenericoHibernate<>(Cliente.class);
        clienteDAOGenericoHibernate.getAll().forEach(System.out::println);
    }
}
