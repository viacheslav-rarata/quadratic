<!DOCTYPE html>
<html>
<head></head>
<body>
	<h2>Quadratic Equations</h2>
	<p>a*x*x + b*x + c = 0</p>
	<form action="">
		<label>Variable a</label> <input type="number" name="a" value="0">
		<br> <label>Variable b</label> <input type="number" name="b"
			value="0"> <br> <label>Variable c</label> <input
			type="number" name="c" value="0"> <br> <input
			type="submit">
	</form>

	<%
		String result = "Woking";
		int a = 0;
		int b = 0;
		int c = 0;
		double x1 = 0.0;
		double x2 = 0.0;
		double d = 0.0;
		try {
			if (request.getParameter("a") != null)
				a = (int) Integer.parseInt(request.getParameter("a"));
			if (request.getParameter("b") != null)
				b = (int) Integer.parseInt(request.getParameter("b"));
			if (request.getParameter("c") != null)
				c = (int) Integer.parseInt(request.getParameter("c"));
			d = b * b - 4 * a * c;
			if (d < 0)
				x1 = d;
			x1 = (-b + Math.sqrt(b * b - 4 * a * c)) / 2 * a;
			x2 = (-b - Math.sqrt(b * b - 4 * a * c)) / 2 * a;
		} catch (Exception e) {
			result = e.getMessage();
			e.printStackTrace();
		}
		if (result.equals("Woking")) {
	%>
	<span>Value d= <%=d%></span>
	<span>Value x1= <%=x1%></span>
	<br>
	<span>Value x2= <%=x2%></span>
	<br>
	<a href="<%=request.getRequestURI()%>">BACK</a>
	<%
		} else {
	%>
	<span>Exception <%=result%></span>
	<%
		}
	%>
</body>
</html>
