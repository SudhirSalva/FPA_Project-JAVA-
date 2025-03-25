<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>FPA Contribution Form</title>
</head>
<body>
    <h2>Contribute to Fire Protection Awareness</h2>
    <form action="ContributeServlet" method="post">
        Name: <input type="text" name="name" required pattern="[a-zA-Z ]+" title="Enter a valid name"><br><br>
        
        Email: <input type="email" name="email" required><br><br>
        
        Contribution Type: 
        <select name="contributionType" id="typeBox" required>
            <option value="Funds">Funds</option>
            <option value="Volunteering">Volunteering</option>
            <option value="Resources">Resources</option>
        </select><br><br>
        
        Amount (if any): <input type="text" name="amount" id="amountField" disabled><br><br>
        
        <input type="submit" value="Submit Contribution">
    </form>

    <script>
        document.getElementById("typeBox").addEventListener("change", function() {
            let amountField = document.getElementById("amountField");
            if (this.value === "Funds") {
                amountField.removeAttribute("disabled");
                amountField.setAttribute("required", "true");
            } else {
                amountField.setAttribute("disabled", "true");
                amountField.removeAttribute("required");
                amountField.value = "";
            }
        });
    </script>
</body>
</html>
