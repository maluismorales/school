package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TableView;

public class CarsController {
	
	final private String host = "localhost";
	private ResultSet resultSet = null;
	private Statement statement = null;	
	private Connection connect = null;		


	public void searchEmployees()  {
		
		String searchTerm = txtEmployees.getText();
		
		try {			
			statement = connect.createStatement();
			resultSet = statement
					.executeQuery("select * FROM classicmodels.employees "
							+ "WHERE lastName LIKE '%" +
							searchTerm + "%' OR firstName LIKE '%"+
							searchTerm + "%' OR email LIKE '%" +
							searchTerm + "%'");
			bp.setCenter(showEmployees(resultSet));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	 
	}
	
	@FXML
	public void searchCustomers(KeyEvent e)  {		

		String searchTerm = txtCustomers.getText();
		
		try {			
			statement = connect.createStatement();
			resultSet = statement
					.executeQuery("select * FROM classicmodels.customers "
							+ "WHERE customerName LIKE '%" +
							searchTerm + "%' OR contactLastName LIKE '%"+
							searchTerm + "%' OR contactFirstName LIKE '%" +
							searchTerm + "%' OR addressLine1 LIKE '%" +
							searchTerm + "%' OR addressLine2 LIKE '%" +
							searchTerm + "%' OR city LIKE '%" +
							searchTerm + "%' OR state LIKE '%" +
							searchTerm + "%' OR country LIKE '%" +
							searchTerm + "%'");
			bp.setCenter(showCustomers(resultSet));
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}	
	}
	
	@FXML
	public void searchOrders(KeyEvent e)  {		

		String searchTerm = txtOrders.getText();
		
		try {			
			statement = connect.createStatement();
			resultSet = statement
					.executeQuery("select * FROM classicmodels.orders "
							+ "WHERE customerNumber LIKE '%" +
							searchTerm + "%' OR orderNumber LIKE '%"+
							searchTerm + "%' OR orderDate LIKE '%" +
							searchTerm + "%' OR requiredDate LIKE '%" +
							searchTerm + "%' OR shippedDate LIKE '%" +
							searchTerm + "%' OR status LIKE '%" +
							searchTerm + "%' OR comments LIKE '%" +
							searchTerm + "%'");
			bp.setCenter(showOrders(resultSet));
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}		
	}

	public void searchPayments(KeyEvent e)  {		

		String searchTerm = txtPayments.getText();
		
		try {			
			statement = connect.createStatement();
			resultSet = statement
					.executeQuery("select * FROM classicmodels.payments "
							+ "WHERE customerNumber LIKE '%" +
							searchTerm + "%' OR checkNumber LIKE '%"+
							searchTerm + "%' OR paymentDate LIKE '%" +
							searchTerm + "%'");
			bp.setCenter(showPayments(resultSet));
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}		
	}
	
	public void searchProducts(KeyEvent e)  {		

		String searchTerm = txtProducts.getText();
		
		try {			
			statement = connect.createStatement();
			resultSet = statement
					.executeQuery("select * FROM classicmodels.products "
							+ "WHERE productCode LIKE '%" +
							searchTerm + "%' OR productName LIKE '%"+
							searchTerm + "%' OR productLine LIKE '%" +
							searchTerm + "%' OR productScale LIKE '%" +
							searchTerm + "%' OR productVendor LIKE '%" +
							searchTerm + "%' OR productDescription LIKE '%" +
							searchTerm + "%' OR MSRP LIKE '%" +
							
							searchTerm + "%'");
			bp.setCenter(showProducts(resultSet));
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}		
	}
	
	
	public void setEmployeeTxtField() {

		txtEmployees.setEditable(true);
		txtEmployees.setText("");

		txtCustomers.setEditable(false);
		txtCustomers.setText("Customers");

		txtOrders.setEditable(false);
		txtOrders.setText("Orders");

		txtPayments.setEditable(false);
		txtPayments.setText("Payments");

		txtProducts.setEditable(false);
		txtProducts.setText("Products");
	}

	public void setCustomersTxtField() {

		txtEmployees.setEditable(false);
		txtEmployees.setText("Employees");

		txtCustomers.setEditable(true);
		txtCustomers.setText("");

		txtOrders.setEditable(false);
		txtOrders.setText("Orders");

		txtPayments.setEditable(false);
		txtPayments.setText("Payments");

		txtProducts.setEditable(false);
		txtProducts.setText("Products");
	}

	public void setOrdersTxtField() {

		txtEmployees.setEditable(false);
		txtEmployees.setText("Employees");

		txtCustomers.setEditable(false);
		txtCustomers.setText("Customers");

		txtOrders.setEditable(true);
		txtOrders.setText("");

		txtPayments.setEditable(false);
		txtPayments.setText("Payments");

		txtProducts.setEditable(false);
		txtProducts.setText("Products");
	}

	public void setPaymentsTxtField() {

		txtEmployees.setEditable(false);
		txtEmployees.setText("Employees");

		txtCustomers.setEditable(false);
		txtCustomers.setText("Customers");

		txtOrders.setEditable(false);
		txtOrders.setText("Orders");

		txtPayments.setEditable(true);
		txtPayments.setText("");

		txtProducts.setEditable(false);
		txtProducts.setText("Products");
	}

	public void setProductsTxtField() {

		txtEmployees.setEditable(false);
		txtEmployees.setText("Employees");

		txtCustomers.setEditable(false);
		txtCustomers.setText("Customers");

		txtOrders.setEditable(false);
		txtOrders.setText("Orders");

		txtPayments.setEditable(false);
		txtPayments.setText("Payments");

		txtProducts.setEditable(true);
		txtProducts.setText("");
	}

	public void getEmployees() {

		try {
			statement = connect.createStatement();
			resultSet = statement.executeQuery("select * from classicmodels.employees");

			bp.setCenter(showEmployees(resultSet));

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void getProducts() {

		try {			
			statement = connect.createStatement();
			resultSet = statement
					.executeQuery("select * from classicmodels.products");		
			
			bp.setCenter(showProducts(resultSet));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	      
	}

	public void getPayments() {
	
		try {			
			statement = connect.createStatement();
			resultSet = statement
					.executeQuery("select * from classicmodels.payments");		
			
			bp.setCenter(showPayments(resultSet));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	      
	}
	
	public void getCustomers() {

		try {			
			statement = connect.createStatement();
			resultSet = statement
					.executeQuery("select * from classicmodels.customers");		
			
			bp.setCenter(showCustomers(resultSet));;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	      
	}

	public void getOrders() {
		
		// Statements allow to issue SQL queries to the database
		// Result set get the result of the SQL query
		try {			
			statement = connect.createStatement();
			resultSet = statement
					.executeQuery("select * from classicmodels.orders");		
			
			bp.setCenter(showOrders(resultSet));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	      
	}
	
	public TableView<Employee> showEmployees(ResultSet results) {		
	
		TableView<Employee> table = new TableView<Employee>();		
			
	    TableColumn employeeNumber = new TableColumn("Emp. No.");
	    employeeNumber.setCellValueFactory(new PropertyValueFactory<>("employeeNumber"));

	    TableColumn lastName = new TableColumn("Last Name");
	    lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		
	    TableColumn firstName = new TableColumn("First Name");
	    firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));

	    TableColumn extension = new TableColumn("Ext.");
	    extension.setCellValueFactory(new PropertyValueFactory<>("extension"));

	    TableColumn email = new TableColumn("Email");
	    email.setCellValueFactory(new PropertyValueFactory<>("email"));

	    TableColumn officeCode = new TableColumn("Office");
	    officeCode.setCellValueFactory(new PropertyValueFactory<>("officeCode"));
	    
	    TableColumn reportsTo = new TableColumn("Mgr");
	    reportsTo.setCellValueFactory(new PropertyValueFactory<>("reportsTo"));

	    TableColumn jobTitle = new TableColumn("Title");
	    jobTitle.setCellValueFactory(new PropertyValueFactory<>("jobTitle"));

	      
	    final ObservableList<Employee> data = FXCollections.observableArrayList();	    		
	  
	   	try {
			while (results.next()) {
				data.add(new Employee(
						results.getString("employeeNumber"),
						results.getString("lastName"),
						results.getString("firstName"),
						results.getString("extension"),
						results.getString("email"),
						results.getString("officeCode"),
						results.getString("reportsTo"),
						results.getString("jobTitle")						
						));				
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	   	
	   	table.setItems(data);	          
	   	table.getColumns().addAll(
	   			employeeNumber,
	   			lastName,
	   			firstName,
	   			extension,
	   			email,
	   			officeCode,
	   			reportsTo,
	   			jobTitle);   	
	   	
	   	return table;
	}

	public TableView<Product> showProducts(ResultSet results) {		
		
		TableView<Product> table = new TableView<Product>();		
			
	    TableColumn productCode = new TableColumn("Code");
	    productCode.setCellValueFactory(new PropertyValueFactory<>("productCode"));

	    TableColumn productName = new TableColumn("Name");
	    productName.setCellValueFactory(new PropertyValueFactory<>("productName"));
		
	    TableColumn productLine = new TableColumn("Line");
	    productLine.setCellValueFactory(new PropertyValueFactory<>("productLine"));

	    TableColumn productScale = new TableColumn("Scale");
	    productScale.setCellValueFactory(new PropertyValueFactory<>("productScale"));
	    
	    TableColumn productVendor = new TableColumn("Vendor");
	    productVendor.setCellValueFactory(new PropertyValueFactory<>("productVendor"));

	    TableColumn productDescription = new TableColumn("Description");
	    productDescription.setCellValueFactory(new PropertyValueFactory<>("productDescription"));

	    TableColumn quantityInStock = new TableColumn("Stock");
	    quantityInStock.setCellValueFactory(new PropertyValueFactory<>("quantityInStock"));

	    TableColumn buyPrice = new TableColumn("Price");
	    buyPrice.setCellValueFactory(new PropertyValueFactory<>("buyPrice"));

	    TableColumn MSRP = new TableColumn("MSRP");
	    MSRP.setCellValueFactory(new PropertyValueFactory<>("MSRP"));

	    
	    final ObservableList<Product> data = FXCollections.observableArrayList();	    		
	  
	   	try {
			while (results.next()) {
				data.add(new Product(
						results.getString("productCode"),
						results.getString("productName"),
						results.getString("productLine"),
						results.getString("productScale"),
						results.getString("productVendor"),
						results.getString("productDescription"),
						results.getString("quantityInStock"),
						results.getString("buyPrice"),
						results.getString("MSRP")	
						));				
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	   	
	   	table.setItems(data);	          
	   	table.getColumns().addAll(
	    		productCode,
	    		productName,
	    		productLine,
	    		productScale,
	    		productVendor,
	    		productDescription,
	    		quantityInStock,
	    		buyPrice,
	    		MSRP
	   			);   	
	   	
	   	return table;
	}

	public TableView<Payment> showPayments(ResultSet results) {

		TableView<Payment> table = new TableView<Payment>();		
		
	    TableColumn customerNumber = new TableColumn("Customer");
	    customerNumber.setCellValueFactory(new PropertyValueFactory<>("customerNumber"));
	    
	    TableColumn checkNumber = new TableColumn("Check");
	    checkNumber.setCellValueFactory(new PropertyValueFactory<>("checkNumber"));
	    
	    TableColumn paymentDate = new TableColumn("Date Paid");	    
	    paymentDate.setCellValueFactory(new PropertyValueFactory<>("paymentDate"));	    

	    TableColumn amount = new TableColumn("Amount");	    
	    amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
	    
	    
	    final ObservableList<Payment> data = FXCollections.observableArrayList();	    		
	  
	   	try {
			while (results.next()) {
				data.add(new Payment(
						results.getString("customerNumber"),
						results.getString("checkNumber"),
						results.getString("paymentDate"),
						results.getString("amount")						
						));				
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	   	
	   	table.setItems(data);	          
	   	table.getColumns().addAll(
	    		customerNumber,
	    		checkNumber,
	    		paymentDate,
	    		amount
	   			);   	
	   	
	   	return table;	   	
	}
		
	public TableView<Customer> showCustomers (ResultSet results) {

		TableView<Customer> table = new TableView<Customer>();		
		
	    TableColumn customerNumber = new TableColumn("Number");
	    customerNumber.setCellValueFactory(new PropertyValueFactory<>("customerNumber"));
	    
	    TableColumn customerName = new TableColumn("Name");
	    customerName.setCellValueFactory(new PropertyValueFactory<>("customerName"));

	    TableColumn contactLastName = new TableColumn("Last Name");
	    contactLastName.setCellValueFactory(new PropertyValueFactory<>("contactLastName"));

	    TableColumn contactFirstName = new TableColumn("First Name");
	    contactFirstName.setCellValueFactory(new PropertyValueFactory<>("contactFirstName"));
	    
	    TableColumn phone = new TableColumn("Phone");
	    phone.setCellValueFactory(new PropertyValueFactory<>("phone"));

	    TableColumn addressLine1 = new TableColumn("Address1");
	    addressLine1.setCellValueFactory(new PropertyValueFactory<>("addressLine1"));

	    TableColumn addressLine2 = new TableColumn("Address2");
	    addressLine2.setCellValueFactory(new PropertyValueFactory<>("addressLine2"));

	    TableColumn city = new TableColumn("City");
	    city.setCellValueFactory(new PropertyValueFactory<>("city"));

	    TableColumn state = new TableColumn("State");
	    state.setCellValueFactory(new PropertyValueFactory<>("state"));

	    TableColumn postalCode = new TableColumn("PostalCode");
	    postalCode.setCellValueFactory(new PropertyValueFactory<>("postalCode"));

	    TableColumn country = new TableColumn("Country");
	    country.setCellValueFactory(new PropertyValueFactory<>("country"));
	    
	    TableColumn salesRepEmployeeNumber = new TableColumn("Rep");
	    salesRepEmployeeNumber.setCellValueFactory(new PropertyValueFactory<>("salesRepEmployeeNumber"));

	    TableColumn creditLimit = new TableColumn("Credit Limt");
	    creditLimit.setCellValueFactory(new PropertyValueFactory<>("creditLimit"));
	    
	    
	    final ObservableList<Customer> data = FXCollections.observableArrayList(); 		
  
    
	   	try {
			while (results.next()) {
				data.add(new Customer (
						results.getString("customerNumber"),
						results.getString("customerName"),
						results.getString("contactLastName"),
						results.getString("contactFirstName"),
						results.getString("phone"),
						results.getString("addressLine1"),
						results.getString("addressLine2"),
						results.getString("city"),
						results.getString("state"),
						results.getString("postalCode"),
						results.getString("country"),
						results.getString("salesRepEmployeeNumber"),
						results.getString("creditLimit")
						));				
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	   	
	   	table.setItems(data);	    	   	
	   	table.getColumns().addAll(
				customerNumber,
				customerName,
				contactLastName,
				contactFirstName,
				phone,
				addressLine1,
				addressLine2,
				city,
				state,
				postalCode,
				country,
				salesRepEmployeeNumber,
				creditLimit	   			
	    );   	
	   	
	   	return table;
	}

	public TableView<Order> showOrders(ResultSet results) {
	TableView<Order> table = new TableView<Order>();		
		
	    TableColumn orderNumber = new TableColumn("Order");
	    orderNumber.setCellValueFactory(new PropertyValueFactory<>("orderNumber"));
	    
	    TableColumn orderDate = new TableColumn("Order Date");
	    orderDate.setCellValueFactory(new PropertyValueFactory<>("orderDate"));

	    TableColumn requiredDate = new TableColumn("Req Date");
	    requiredDate.setCellValueFactory(new PropertyValueFactory<>("requiredDate"));

	    TableColumn shippedDate = new TableColumn("Ship Date");
	    shippedDate.setCellValueFactory(new PropertyValueFactory<>("shippedDate"));

	    TableColumn status = new TableColumn("Status");
	    status.setCellValueFactory(new PropertyValueFactory<>("status"));

	    TableColumn comments = new TableColumn("Comments");
	    comments.setCellValueFactory(new PropertyValueFactory<>("comments"));
	    
	    TableColumn customerNumber = new TableColumn("Cus No.");
	    customerNumber.setCellValueFactory(new PropertyValueFactory<>("customerNumber"));
	    
	    final ObservableList<Order> data = FXCollections.observableArrayList();	    		
	  
	   	try {
			while (results.next()) {
				data.add(new Order(
						results.getString("orderNumber"),
						results.getString("orderDate"),
						results.getString("requiredDate"),
						results.getString("shippedDate"),
						results.getString("status"),
						results.getString("comments"),
						results.getString("customerNumber")
						));				
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	   	
	   	table.setItems(data);	          
	   	table.getColumns().addAll(
	   			orderNumber,
	   			orderDate,
	   			requiredDate,
	   			shippedDate,
	   			status,
	   			comments,
	   			customerNumber
	   			);   	
	   	
	   	return table;		
	}
	
    // set the Log On Icon to on LoggedIn.jpg
    public void logOnIcon(boolean set) {

    	String img;
    	if (set == true) {
    		 img = "LoggedIn.jpg";
    	}else { img = "LoggedOut.jpg";}
    	
        try {
			Image image = new Image(new FileInputStream(img));
			imgLogIn.setImage(image);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}     	
    }
		
	public void enableToolBar (boolean val) {
		butCustomers.setDisable(!val);
		butEmployees.setDisable(!val);		
		butOrders.setDisable(!val);
		butPayments.setDisable(!val);
		butProducts.setDisable(!val);		
	}
		
	public void enableSearchBox(boolean val) {		
		txtCustomers.setDisable(!val);
		txtEmployees.setDisable(!val);
		txtOrders.setDisable(!val);
		txtPayments.setDisable(!val);
		txtProducts.setDisable(!val);
		
	}
		
	public void closeConnection() {
		try {
			connect.close();
			txtAreaLog.appendText("\nClosing Connection");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
		
    public void logInOut () {  
    	    	
		if (butLogin.getText().compareTo("Log In")==0)  {
    	
		try {
			connect =
			DriverManager.getConnection("jdbc:mysql://" + host + "/classicmodels?"
			+ "user=" + txtUsername.getText() + "&password=" + password.getText() );
			
			txtAreaLog.appendText("\n Successful Connection");
			txtAreaLog.appendText("\n Catalog(s): " + connect.getCatalog());
			txtUsername.setDisable(true);
			password.setDisable(true);
			loginId.setText(txtUsername.getText());	
			butLogin.setText("Log Off");
			enableToolBar(true);
			enableSearchBox(true);			
			logOnIcon(true);
				
			
		} catch (SQLException ex) {
			// handle any errors
			txtAreaLog.appendText("\nSQLException: " + ex.getMessage());
			txtAreaLog.appendText("\nSQLState: " + ex.getSQLState());
			txtAreaLog.appendText("\nVendorError: " + ex.getErrorCode());			
		}
		finally {
			// clean up;
		}
		
		// Log out
		}else {
			try {				
				connect.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			butLogin.setText("Log In");			
			txtAreaLog.appendText("\n Closed connection");
			txtUsername.setDisable(false);			
			password.setDisable(false);
			loginId.setText("Username");	
			txtUsername.setText("UserName");
			password.setText("temp");
			enableToolBar(false);
			enableSearchBox(false);
			bp.setCenter(null);
			logOnIcon(false);
			
			
		}
		
	}

// Auto Generated
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private BorderPane bp;

    @FXML
    private GridPane topGp;

    @FXML
    private ImageView imgLogIn;

    @FXML
    private Label lblAppTitle;

    @FXML
    private Button butCustomers;

    @FXML
    private Button butEmployees;

    @FXML
    private Button butOrders;

    @FXML
    private Button butPayments;

    @FXML
    private Button butProducts;

    @FXML
    private Label loginId;

//    @FXML
 //   private TableView<?> tblResults;

    @FXML
    private GridPane gpLogon;

    @FXML
    private Label lblEnterLogin;

    @FXML
    private TextField txtUsername;

    @FXML
    private PasswordField password;

    @FXML
    private Button butLogin;

    @FXML
    private GridPane gpSearch;

    @FXML
    private TextField txtCustomers;

    @FXML
    private TextField txtEmployees;

    @FXML
    private TextField txtOrders;

    @FXML
    private TextField txtPayments;

    @FXML
    private TextField txtProducts;

    @FXML
    private Button butSearch;

    @FXML
    private TextArea txtAreaLog;

    @FXML
    void initialize() {
        assert bp != null : "fx:id=\"bp\" was not injected: check your FXML file 'Cars.fxml'.";
        assert topGp != null : "fx:id=\"topGp\" was not injected: check your FXML file 'Cars.fxml'.";
        assert imgLogIn != null : "fx:id=\"imgLogIn\" was not injected: check your FXML file 'Cars.fxml'.";
        assert lblAppTitle != null : "fx:id=\"lblAppTitle\" was not injected: check your FXML file 'Cars.fxml'.";
        assert butCustomers != null : "fx:id=\"butCustomers\" was not injected: check your FXML file 'Cars.fxml'.";
        assert butEmployees != null : "fx:id=\"butEmployees\" was not injected: check your FXML file 'Cars.fxml'.";
        assert butOrders != null : "fx:id=\"butOrders\" was not injected: check your FXML file 'Cars.fxml'.";
        assert butPayments != null : "fx:id=\"butPayments\" was not injected: check your FXML file 'Cars.fxml'.";
        assert butProducts != null : "fx:id=\"butProducts\" was not injected: check your FXML file 'Cars.fxml'.";
        assert loginId != null : "fx:id=\"loginId\" was not injected: check your FXML file 'Cars.fxml'.";
        assert gpLogon != null : "fx:id=\"gpLogon\" was not injected: check your FXML file 'Cars.fxml'.";
        assert lblEnterLogin != null : "fx:id=\"lblEnterLogin\" was not injected: check your FXML file 'Cars.fxml'.";
        assert txtUsername != null : "fx:id=\"txtUsername\" was not injected: check your FXML file 'Cars.fxml'.";
        assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'Cars.fxml'.";
        assert butLogin != null : "fx:id=\"butLogin\" was not injected: check your FXML file 'Cars.fxml'.";
        assert gpSearch != null : "fx:id=\"gpSearch\" was not injected: check your FXML file 'Cars.fxml'.";
        assert txtCustomers != null : "fx:id=\"txtCustomers\" was not injected: check your FXML file 'Cars.fxml'.";
        assert txtEmployees != null : "fx:id=\"txtEmployees\" was not injected: check your FXML file 'Cars.fxml'.";
        assert txtOrders != null : "fx:id=\"txtOrders\" was not injected: check your FXML file 'Cars.fxml'.";
        assert txtPayments != null : "fx:id=\"txtPayments\" was not injected: check your FXML file 'Cars.fxml'.";
        assert txtProducts != null : "fx:id=\"txtProducts\" was not injected: check your FXML file 'Cars.fxml'.";
        assert butSearch != null : "fx:id=\"butSearch\" was not injected: check your FXML file 'Cars.fxml'.";
        assert txtAreaLog != null : "fx:id=\"txtAreaLog\" was not injected: check your FXML file 'Cars.fxml'.";

    }
}
