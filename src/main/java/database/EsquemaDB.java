package database;

public interface EsquemaDB {

    String DB_NAME = "almacen";

    String TAB_CUSTOMERS="customers";
    String COL_ID_CUSTOMERS ="idCustomer";
    String COL_NAME = "name";
    String COL_FIRST_LASTNAME = "first_lastname";
    String COL_SECOND_LASTNAME = "second_lastname";
    String COL_EMAIL = "email";
    String COL_PASSWORD = "password";
    String COL_PHONE = "phone";
    String COL_ADDRESS = "address";
    String COL_CREATED_AT = "created_at";

    String TAB_ORDERED_PRODUCTS = "orderedproducts";
    String COL_ID_ORDERED_PRODUCT = "id";
    String COL_ORDER_ID = "order_id";
    String COL_PRODUCT_ID = "product_id";
    String COL_QUANTITY = "quantity";

    String TAB_ORDERS = "orders";
    String COL_ID_ORDER = "idPedido";
    String COL_DATE = "date";
    String COL_FECHA_PEDIDO = "fechaPedido";
    String COL_FECHA_ENTREGA = "fechaEntrega";
    String COL_METODO_DE_PAGO = "metodoDePago";
    String COL_TOTAL = "total";
    String COL_COMENTARIOS = "comentarios";
    String COL_DIRECCION_ENTREGA = "direccionEntrega";
    String COL_ESTADO = "estado";

    String TAB_PRODUCTS = "products";
    String COL_ID_PRODUCT = "id";
    String COL_TITLE = "title";
    String COL_DESCRIPTION = "description";
    String COL_CATEGORY = "category";
    String COL_PRICE = "price";
    String COL_AVAILABILITY_STATUS = "availabilityStatus";
    String COL_DISCOUNT_PERCENTAGE = "discountPercentage";
    String COL_RATING = "rating";
    String COL_IMAGES = "images";
    String COL_STOCK = "stock";
    String COL_DIMENSIONS_DEPTH = "dimensions_depth";
    String COL_DIMENSIONS_HEIGHT = "dimensions_height";
    String COL_DIMENSIONS_WIDTH = "dimensions_width";
    String COL_SHIPPING_INFORMATION = "shippingInformation";
    String COL_WARRANTY_INFORMATION = "warrantyInformation";
    String COL_WEIGHT = "weight";
    String COL_SKU = "sku";
    String COL_THUMBNAIL = "thumbnail";


}
