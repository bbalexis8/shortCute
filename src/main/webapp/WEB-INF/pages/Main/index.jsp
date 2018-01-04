<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>URL ShortCute : raccourci d'adresse Web</title>


    <spring:url value="/resources/css/style.css" var="mainCss" />
    <spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss" />
    <spring:url value="/resources/css/style.css" var="logo-navCss" />

    <link href="${mainCss}" rel="stylesheet" />
    <link href="${bootstrapCss}" rel="stylesheet" />
    <link href="${logo-navCss}" rel="stylesheet" />

  </head>

  <body>

      <!-- Navigation -->
      <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
          <div class="container">
              <div class="navbar-header">
                  <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                      <span class="sr-only">Toggle navigation</span>
                  </button>
                  <a class="navbar-brand" href="#">ShortCute</a>
              </div>

          </div>
      </nav>

      <!-- Page Content -->
      <div class="container" style="margin-top: 65px;">

          <div class="row">

              <div class="col-xs-12 col-sm-12 col-md-8 col-md-offset-2 col-lg-8 col-lg-offset-2">
                  <p class="lead">Formulaire</p>
                  <div class="list-group">
                        <form:form method="POST" modelAttribute="Url" action="/addUrl">
                            <form:errors path="*" cssClass="errorblock" element="div" />
                            <label for="chaine">Saisir url : </label>
                            <td><form:input type="text" id="chaine" class="form-control" path="chaine" /></td>
                            <button class="btn btn-primary btn-block" type="submit">Soumettre l'URL</button>
                        </form:form>
                  </div>
              </div>
              <div class="col-xs-12 col-sm-12 col-md-8 col-md-offset-2 col-lg-8 col-lg-offset-2">
              <label>Url saisie :</label>
                  <label></label>
              </div>
              <div class="col-xs-12 col-sm-12 col-md-8 col-md-offset-2 col-lg-8 col-lg-offset-2">
              <div class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
                  <div class="well">
                      <div class="text-right">
                           Nombre de liens
                      </div>
                  </div>
              </div>
              <div class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
                  <div class="well">
                      <div class="text-right">
                          Nombre d'Utilisateurs
                      </div>
                  </div>
              </div>
              <div class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
                  <div class="well">
                      <div class="text-right">
                          Money Money Money
                      </div>
                  </div>
              </div>
              </div>
          </div>
      </div>

      <!-- jQuery & Bootstrap -->
      <spring:url value="/resources/js/jquery.js" var="jqueryJs" />
      <spring:url value="/resources/js/bootstrap.min.js" var="bootstrapJs" />

      <script src="${jqueryJs}" type="text/javascript"></script>
      <script src="${bootstrapJs}" type="text/javascript"></script>

  </body>
</html>