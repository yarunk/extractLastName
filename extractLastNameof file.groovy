import com.sap.gateway.ip.core.customdev.util.Message
import java.util.Date

def Message processData(Message message) {
    def fileName = message.getProperties().get("ServicePath")
    
    // Check if fileName is null before proceeding
    if (fileName != null) {
        def lastPart = extractLastName(fileName)

        message.setProperty("Service", lastPart)
    } 
    
    return message
}

// Function to extract the name after the last slash
def extractLastName(fileName) {
    def index = fileName.lastIndexOf("/")
    if (index != -1) {
        // Extract the part after the last "/"
        def lastPart = fileName.substring(index + 1)
        return lastPart
    } 
}
