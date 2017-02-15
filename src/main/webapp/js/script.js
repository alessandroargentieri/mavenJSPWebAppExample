// Event handling
document.addEventListener("DOMContentLoaded",
    function (event) {

    // $("#submit").click(function(){alert("clicked!");}); //little example of JQuery use
    //$("#logout").click( function(){  $("#maincontainer").remove(); window.location.href = 'index.html';  });

      $("#submit").click(function(){
                            //acquisisco la domanda nella textarea  
                            var question = $("#question").val();
                            var id_paziente = $('#id_paziente').val();
                            var nominativo = $('#nominativo').val();
                            
                            //preparo il codice HTML da visualizzare (domanda)
                            var user_question = '<section><div class="col-sx-4 col-md-2 col-lg-1"><img src="images/user-icon.png" /></div><div class="col-sx-8 col-md-10 col-lg-11"> <p>' + question + '</p></div></section>';
                            //visualizzazione della domanda del paziente                  
                            $("#chat").prepend(user_question);
                            //preparo la GIF del bot che sta scrivendo la risposta
                            var response = '<section id="temporary"><div class="col-sx-4 col-md-2 col-lg-1"><img src="images/doctor-icon.png" /></div> <div class="col-sx-8 col-md-10 col-lg-11"> <p><img src="images/ajax-loader.gif" /></p></div></section>';
                            
                            // attendo 2 secondi prima di visualizzare i puntini di sospensione
                            setTimeout(function(){ $("#chat").prepend(response); }, 2000);
                            //il codice continua senza attendere che siano passati i tre secondi, ma il php aspetta 5 secondi prima di aggiornare

                            // richiesta ajax al server e seguente visualizzazione asincrona della risposta
                            var url = "queryMe.php?question=" + question + "&id_paziente=" + id_paziente + "&nominativo=" + nominativo;  
                            $ajaxUtils.sendGetRequest(url, function (request) {
                                                               //quando arriva la risposta asincrona dal php...
                                                               var response = request.responseText;
                                                                $("#temporary").remove();
                                                                $("#chat").prepend(response);
                                                           }
                                                      );
                                    }
 

                        );


    // Same thing without JQuery but with classic Javascript
   /*   document.querySelector("#submit").addEventListener("click", function () {
                                                                 // alert("hello button pressed!");
                                                                  $ajaxUtils.sendGetRequest("data/name.txt", function (request) {
                                                                                                                  var name = request.responseText;
                                                                                                                  document.querySelector("#content").innerHTML = "<h2>Hello " + name + "!</h2>";
                                                                                                             });
       
      }); */
    }
);




