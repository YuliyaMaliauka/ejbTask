package classes.by.gsu.epamlab.constants;

public interface Constants {
	public static final String URL_REG = "/registration.jsp";
	public static final String CLASS_NAME = "org.gjt.mm.mysql.Driver";
	public static final String DB_URL = "jdbc:mysql://localhost/todo";
	public static final String USER_NAME_DB = "jse";
	public static final String PASSWORD_DB = "jse";
	
	public static final String NOT_DRIVER_BD = "Not initialize driver";
	public static final String PROBLEM_CLOSE_RESOURCE = "problem for close resource:";
	
	public final static String SELECT_USERS = "SELECT * FROM users";
	public final static String INSERT_USERS = "INSERT INTO users (name, password) VALUES (?, ?)";
	
}
