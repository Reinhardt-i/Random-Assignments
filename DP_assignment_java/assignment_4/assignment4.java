/**
 * Adapter Pattern Example: JSON, XML, and Proto Data Conversion
 *
 * Scenario:
 * We have a system that processes data in three different formats: JSON, XML, and Proto. The system uses different
 * classes to represent each data format. However, we want to provide a unified interface to the clients so they can
 * convert data from one format to another without knowing the specific conversion logic for each pair of formats.
 *
 * Implementation:
 * To achieve this, we use the Adapter pattern, which allows us to create adapter classes that implement the common
 * conversion logic between different formats. Each adapter class adheres to the common interface defined by the
 * `DataAdapter` interface. This way, clients can interact with the adapters uniformly without worrying about the
 * underlying details of data conversion.
 *
 * The `DataAdapter` interface serves as the common interface for all adapters, providing a `convert` method to perform
 * the conversion. Concrete adapter classes are implemented for converting JSON to XML (`JsonToXmlAdapter`), XML to JSON
 * (`XmlToJsonAdapter`), and Proto to XML (`ProtoToXmlAdapter`).
 *
 * The `DataConverter` class is the main class that utilizes the adapter pattern. It accepts a `DataAdapter` instance
 * during initialization and provides a `convert` method to perform the data conversion. The client doesn't need to know
 * which concrete adapter is being used; it simply relies on the `DataAdapter` interface.
 *
 * Usage:
 * 1. Create instances of different data classes (JSON, XML, Proto).
 * 2. Instantiate the corresponding adapter classes (JsonToXmlAdapter, XmlToJsonAdapter, ProtoToXmlAdapter).
 * 3. Initialize the `DataConverter` class with the desired adapter.
 * 4. Use the `DataConverter` to convert data between different formats using the adapter.
 *
 * Note:
 * In this example, the actual conversion logic for Proto to XML and vice versa is the same. In a real-world scenario,
 * the conversion logic may differ for different formats, and that's where the adapter pattern becomes particularly
 * useful, as it encapsulates the conversion details and allows for easy extension and maintenance.
 */

// Data format classes
interface DataAdapter<T> {
    T convert(T data);
}

class JSON {
    private String data;

    public JSON(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return data;
    }
}

class XML {
    private String data;

    public XML(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return data;
    }
}

class Proto {
    private String data;

    public Proto(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return data;
    }
}

// Adapter classes
class JsonToXmlAdapter implements DataAdapter<JSON> {
    @Override
    public XML convert(JSON data) {
        String xmlData = "<xml>" + data.getData() + "</xml>";
        return new XML(xmlData);
    }
}

class XmlToJsonAdapter implements DataAdapter<XML> {
    @Override
    public JSON convert(XML data) {
        // Logic to convert XML data to JSON
        String jsonData = "{\"xml_data\": \"" + data.getData() + "\"}";
        return new JSON(jsonData);
    }
}

class ProtoToXmlAdapter implements DataAdapter<Proto> {
    @Override
    public XML convert(Proto data) {
        // Logic to convert Proto data to XML (similar to JsonToXmlAdapter)
        String xmlData = "<xml>" + data.getData() + "</xml>";
        return new XML(xmlData);
    }
}

// Client class utilizing the adapter pattern
class DataConverter<T> {
    private DataAdapter<T> adapter;

    public DataConverter(DataAdapter<T> adapter) {
        this.adapter = adapter;
    }

    public T convert(T data) {
        return adapter.convert(data);
    }
}

class Main {
    public static void main(String[] args) {
        // Usage
        DataAdapter<JSON> jsonToXmlAdapter = new JsonToXmlAdapter();
        DataConverter<JSON> client1 = new DataConverter<>(jsonToXmlAdapter);
        JSON jsonData = new JSON("{\"key\": \"value\"}");
        XML xmlData = client1.convert(jsonData);
        System.out.println("JSON to XML Data: " + xmlData);

        DataAdapter<XML> xmlToJsonAdapter = new XmlToJsonAdapter();
        DataConverter<XML> client2 = new DataConverter<>(xmlToJsonAdapter);
        XML xmlData2 = new XML("<xml><key>value</key></xml>");
        JSON jsonData2 = client2.convert(xmlData2);
        System.out.println("XML to JSON Data: " + jsonData2);

        DataAdapter<Proto> protoToXmlAdapter = new ProtoToXmlAdapter();
        DataConverter<Proto> client3 = new DataConverter<>(protoToXmlAdapter);
        Proto protoData = new Proto("proto-data");
        XML xmlData3 = client3.convert(protoData);
        System.out.println("Proto to XML Data: " + xmlData3);
    }
}
