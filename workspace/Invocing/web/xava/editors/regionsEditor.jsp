<%@ page import="java.util.Collection" %>
<%@ page import="java.util.Collections" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="org.openxava.util.Labels" %>
<%@ page import="java.sql.SQLOutput" %>

<jsp:useBean id="style" class="org.openxava.web.style.Style" scope="request"/>

<%
    String propertyKey = request.getParameter("propertyKey");
    System.out.println("propertyKey: " + propertyKey);
    String [] fvalues = (String []) request.getAttribute(propertyKey + ".fvalue"); // 1
    System.out.println("fvalues: " + fvalues);
    boolean editable="true".equals(request.getParameter("editable"));
    System.out.println("editable:" + editable);
    String disabled=editable?"":"disabled";
    String script = request.getParameter("script");
    System.out.println("script: " + script);
    boolean label = org.openxava.util.XavaPreferences.getInstance().isReadOnlyAsLabel();
    System.out.println("label: " + label);
    if (editable || !label) {
        String sregionsCount = request.getParameter("regionsCount");
        System.out.println("sregionsCount: " + sregionsCount);
        int regionsCount = sregionsCount == null?5:Integer.parseInt(sregionsCount);
        System.out.println("regionsCount: " + regionsCount);
        Collection regions = fvalues==null?Collections.EMPTY_LIST:Arrays.asList(fvalues);
        System.out.println("regions: " + regions);
%>
<select id="<%=propertyKey%>" name="<%=propertyKey%>" multiple="multiple"
        class=<%=style.getEditor()%>
            <%=disabled%>
        <% System.out.println("in select disabled:" + disabled);%>
        <%=script%>>
    <%
        for (int i=1; i<regionsCount+1; i++) {
            String selected = regions.contains(Integer.toString(i))?"selected":"";
    %>
    <option
            value="<%=i%>" <%=selected%>>
        <%=Labels.get("regions." + i, request.getLocale())%>
    </option>
    <%
        }
    %>
</select>
<%
}
else {
    for (int i=0; i<fvalues.length; i++) {
%>
<%=Labels.get("regions." + fvalues[i], request.getLocale())%>
<%
        }
    }
%>

<%
    if (!editable) {
        for (int i=0; i<fvalues.length; i++) {
%>
<input type="hidden" name="<%=propertyKey%>" value="<%=fvalues[i]%>">
<%
        }
    }
%>