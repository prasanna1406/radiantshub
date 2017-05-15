<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Hello WebSocket</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href='<c:url value="/resources/css/reservation.css"/>'>
<!-- <link href="/main.css" rel="stylesheet"> -->

<style type="text/css">
body{
    height:400px;
    position: fixed;
    bottom: 0;
}
.col-md-2, .col-md-10{
    padding:0;
}
.panel{
    margin-bottom: 0px;
}
.chat-window{
    bottom:0;
    position:fixed;
    float:right;
    margin-left:10px;
}
.chat-window > div > .panel{
    border-radius: 5px 5px 0 0;
}
.icon_minim{
    padding:2px 10px;
}
.msg_container_base{
  background: #e5e5e5;
  margin: 0;
  padding: 0 10px 10px;
  max-height:300px;
  overflow-x:hidden;
}
.top-bar {
  background: #666;
  color: white;
  padding: 10px;
  position: relative;
  overflow: hidden;
}
.msg_receive{
    padding-left:0;
    margin-left:0;
}
.msg_sent{
    padding-bottom:20px !important;
    margin-right:0;
}
.messages {
  background: white;
  padding: 10px;
  border-radius: 2px;
  box-shadow: 0 1px 2px rgba(0, 0, 0, 0.2);
  max-width:100%;
}
.messages > p {
    font-size: 13px;
    margin: 0 0 0.2rem 0;
  }
.messages > time {
    font-size: 11px;
    color: #ccc;
}
.msg_container {
    padding: 10px;
    overflow: hidden;
    display: flex;
}
img {
    display: block;
    width: 100%;
}
.avatar {
    position: relative;
}
.base_receive > .avatar:after {
    content: "";
    position: absolute;
    top: 0;
    right: 0;
    width: 0;
    height: 0;
    border: 5px solid #FFF;
    border-left-color: rgba(0, 0, 0, 0);
    border-bottom-color: rgba(0, 0, 0, 0);
}

.base_sent {
  justify-content: flex-end;
  align-items: flex-end;
}
.base_sent > .avatar:after {
    content: "";
    position: absolute;
    bottom: 0;
    left: 0;
    width: 0;
    height: 0;
    border: 5px solid white;
    border-right-color: transparent;
    border-top-color: transparent;
    box-shadow: 1px 1px 2px rgba(black, 0.2); // not quite perfect but close
}

.msg_sent > time{
    float: right;
}



.msg_container_base::-webkit-scrollbar-track
{
    -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);
    background-color: #F5F5F5;
}

.msg_container_base::-webkit-scrollbar
{
    width: 12px;
    background-color: #F5F5F5;
}

.msg_container_base::-webkit-scrollbar-thumb
{
    -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,.3);
    background-color: #555;
}

.btn-group.dropup{
    position:fixed;
    left:0px;
    bottom:0;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/sockjs/1/sockjs.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>

</head>
<body>
	<noscript>
		<h2 style="color: #ff0000">Seems your browser doesn't support
			Javascript! Websocket relies on Javascript being enabled. Please
			enable Javascript and reload this page!</h2>
	</noscript>
	<!-- <div id="main-content" class="container">
		<div class="row">
			<div class="col-md-6">
				<form class="form-inline">
					<div class="form-group">
						<label for="connect">WebSocket connection:</label>
						<button id="connect" class="btn btn-default" type="submit">Connect</button>
						<button id="disconnect" class="btn btn-default" type="submit"
							disabled="disabled">Disconnect</button>
					</div>
				</form>
			</div>
			<div class="col-md-6">
				<form class="form-inline">
					<div class="form-group">sd
						<label for="name">What is your name?</label> <input type="text"
							id="name" class="form-control" placeholder="Your name here...">
					</div>
					<button id="send" class="btn btn-default" type="submit">Send</button>
				</form>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<table id="conversation" class="table table-striped">
					<thead>
						<tr>
							<th>Greetings</th>
						</tr>
					</thead>
					<tbody id="greetings">
					</tbody>
				</table>
			</div>
		</div>

	</div> -->

	<div class="container">
		<div class="row chat-window col-xs-10 col-md-3" id="chat_window_1"
			style="margin-left: 10px;">
			<div class="col-xs-12 col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading top-bar">
						<div class="col-md-8 col-xs-8">
							<h3 class="panel-title">
								<span class="glyphicon glyphicon-comment"></span> Chat - Miguel
							</h3>
						</div>
						<div class="col-md-4 col-xs-4" style="text-align: right;">
							<a href="#"><span id="minim_chat_window"
								class="glyphicon glyphicon-minus icon_minim"></span></a> 
						</div>
					</div>
					<div class="panel-body msg_container_base" id="messagesDiv">
						<div class="row msg_container base_sent">
							<div class="col-md-10 col-xs-10">
								<div class="messages msg_sent">
									<p>that mongodb thing looks good, huh? tiny master db, and
										huge document store</p>
									<time datetime="2009-11-13T20:00">Timothy • 51 min</time>
								</div>
							</div>
							<div class="col-md-2 col-xs-2 avatar">
								<img
									src="http://www.bitrebels.com/wp-content/uploads/2011/02/Original-Facebook-Geek-Profile-Avatar-1.jpg"
									class=" img-responsive ">
							</div>
						</div>
						<div class="row msg_container base_receive">
							<div class="col-md-2 col-xs-2 avatar">
								<img
									src="http://www.bitrebels.com/wp-content/uploads/2011/02/Original-Facebook-Geek-Profile-Avatar-1.jpg"
									class=" img-responsive ">
							</div>
							<div class="col-md-10 col-xs-10">
								<div class="messages msg_receive">
									<p>that mongodb thing looks good, huh? tiny master db, and
										huge document store</p>
									<time datetime="2009-11-13T20:00">Timothy • 51 min</time>
								</div>
							</div>
						</div>
						<div class="row msg_container base_receive">
							<div class="col-md-2 col-xs-2 avatar">
								<img
									src="http://www.bitrebels.com/wp-content/uploads/2011/02/Original-Facebook-Geek-Profile-Avatar-1.jpg"
									class=" img-responsive ">
							</div>
							<div class="col-xs-10 col-md-10">
								<div class="messages msg_receive">
									<p>that mongodb thing looks good, huh? tiny master db, and
										huge document store</p>
									<time datetime="2009-11-13T20:00">Timothy • 51 min</time>
								</div>
							</div>
						</div>
						<div class="row msg_container base_sent">
							<div class="col-xs-10 col-md-10">
								<div class="messages msg_sent">
									<p>that mongodb thing looks good, huh? tiny master db, and
										huge document store</p>
									<time datetime="2009-11-13T20:00">Timothy • 51 min</time>
								</div>
							</div>
							<div class="col-md-2 col-xs-2 avatar">
								<img
									src="http://www.bitrebels.com/wp-content/uploads/2011/02/Original-Facebook-Geek-Profile-Avatar-1.jpg"
									class=" img-responsive ">
							</div>
						</div>
						<div class="row msg_container base_receive">
							<div class="col-md-2 col-xs-2 avatar">
								<img
									src="http://www.bitrebels.com/wp-content/uploads/2011/02/Original-Facebook-Geek-Profile-Avatar-1.jpg"
									class=" img-responsive ">
							</div>
							<div class="col-xs-10 col-md-10">
								<div class="messages msg_receive">
									<p>that mongodb thing looks good, huh? tiny master db, and
										huge document store</p>
									<time datetime="2009-11-13T20:00">Timothy • 51 min</time>
								</div>
							</div>
						</div>
						<div class="row msg_container base_sent">
							<div class="col-md-10 col-xs-10 ">
								<div class="messages msg_sent">
									<p>that mongodb thing looks good, huh? tiny master db, and
										huge document store</p>
									<time datetime="2009-11-13T20:00">Timothy • 51 min</time>
								</div>
							</div>
							<div class="col-md-2 col-xs-2 avatar">
								<img
									src="http://www.bitrebels.com/wp-content/uploads/2011/02/Original-Facebook-Geek-Profile-Avatar-1.jpg"
									class=" img-responsive ">
							</div>
						</div>
					</div>
					<div class="panel-footer">
						<form class="form-inline">
						<div class="input-group">
							<input id="name" type="text"
								class="form-control input-sm chat_input"
								placeholder="Write your message here..." /> <span
								class="input-group-btn">
								<button class="btn btn-primary btn-sm" id="send">Send</button>
							</span>
						</div>
						</form>
					</div>
				</div>
			</div>
		</div>

		<div class="btn-group dropup">
			<button type="button" class="btn btn-default dropdown-toggle"
				data-toggle="dropdown">
				<span class="glyphicon glyphicon-cog"></span> <span class="sr-only">Toggle
					Dropdown</span>
			</button>
			<ul class="dropdown-menu" role="menu">
				<li><a href="#" id="new_chat"><span
						class="glyphicon glyphicon-plus"></span> Novo</a></li>
				<li><a href="#"><span class="glyphicon glyphicon-list"></span>
						Ver outras</a></li>
				<li><a href="#"><span class="glyphicon glyphicon-remove"></span>
						Fechar Tudo</a></li>
				<li class="divider"></li>
				<li><a href="#"><span class="glyphicon glyphicon-eye-close"></span>
						Invisivel</a></li>
			</ul>
		</div>
	</div>


	<!-- Trigger/Open The Modal -->
	<%-- <input type="hidden" id="amount" value="200">
	<input type="hidden" id="currency" value="USD">
	<input type="hidden" name="redirectUrl" id="redirectUrl"
			value="http://192.168.1.157:8080/MyPortal/compiler/login"> 
	<button id="myBtn">Book</button>
	

	<!-- The Modal -->
	

	<script src='<c:url value="/resources/js/reservation.js"/>'></script> --%>

	<script type="text/javascript">
		/* var stompClient = null;

		function setConnected(connected) {
			$("#connect").prop("disabled", connected);
			$("#disconnect").prop("disabled", !connected);
			if (connected) {
				$("#conversation").show();
			} else {
				$("#conversation").hide();
			}
			$("#greetings").html("");
		}

		function connect() {
			var socket = new SockJS('/Radiants/chat');
			console.log(socket);
			stompClient = Stomp.over(socket);
			console.log(stompClient);
			stompClient.connect({}, function(frame) {
				setConnected(true);
				console.log('Connected: ' + frame);
				stompClient.subscribe('/topic/greetings', function(greeting) {
					showGreeting(JSON.parse(greeting.body).content);
				});
			});
		}

		function disconnect() {
			if (stompClient != null) {
				stompClient.disconnect();
			}
			setConnected(false);
			console.log("Disconnected");
		}

		function sendName() {
			stompClient.send("/app/hello", {}, JSON.stringify({
				'name' : $("#name").val()
			}));
		}

		function showGreeting(message) {
			$("#greetings").append("<tr><td>" + message + "</td></tr>");
		}

		$(function() {
			$("form").on('submit', function(e) {
				e.preventDefault();
			});
			$("#connect").click(function() {
				connect();
			});
			$("#disconnect").click(function() {
				disconnect();
			});
			$("#send").click(function() {
				sendName();
			});
		}); */

		var stompClient = null;

		function setConnected(connected) {
		    $("#connect").prop("disabled", connected);
		    $("#disconnect").prop("disabled", !connected);
		    if (connected) {
		        $("#conversation").show();
		    }
		    else {
		        $("#conversation").hide();
		    }
		    $("#greetings").html("");
		}

		function connect() {
		    var socket = new SockJS('chat');
		    stompClient = Stomp.over(socket);
		    stompClient.connect({}, function (frame) {
		        setConnected(true);
		        console.log('Connected: ' + frame);
		        stompClient.subscribe('/topic/greetings', function (greeting) {
		            showGreeting(JSON.parse(greeting.body).content);
		        });
		    });
		}

		function disconnect() {
		    if (stompClient != null) {
		        stompClient.disconnect();
		    }
		    setConnected(false);
		    console.log("Disconnected");
		}

		function sendName() {
			if($("#name").val()!=""){
				stompClient.send("/app/hello", {}, JSON.stringify({'name': $("#name").val()}));
				$("#name").val("");
			}
		}
		var count = 0;
		function showGreeting(message) {
			count++;
			
			var odd = "<div class='row msg_container base_sent'><div class='col-md-10 col-xs-10'><div class='messages msg_sent'>"+
						"<p>"+message+"</p><time datetime="+new Date()+">Guest • "+new Date().getMinutes()+" min</time></div></div>"+
						"<div class='col-md-2 col-xs-2 avatar'><img src='http://www.bitrebels.com/wp-content/uploads/2011/02/Original-Facebook-Geek-Profile-Avatar-1.jpg'"+
						"class=' img-responsive '></div></div>";
					
				
			if(count%2==1){
				
			}else{
				
			}
				
		    $("#messagesDiv").append(odd);
		    $("#messagesDiv").animate({ scrollTop: $('#messagesDiv').prop("scrollHeight")}, 1000);
		}
		connect();
		$(function () {
		    $("form").on('submit', function (e) {
		        e.preventDefault();
		    });
		    $( "#connect" ).click(function() { connect(); });
		    $( "#disconnect" ).click(function() { disconnect(); });
		    $( "#send" ).click(function() { sendName(); });
		});
		
		
		$(document).on('click', '.panel-heading span.icon_minim', function (e) {
		    var $this = $(this);
		    if (!$this.hasClass('panel-collapsed')) {
		        $this.parents('.panel').find('.panel-body').slideUp();
		        $this.addClass('panel-collapsed');
		        $this.removeClass('glyphicon-minus').addClass('glyphicon-plus');
		    } else {
		        $this.parents('.panel').find('.panel-body').slideDown();
		        $this.removeClass('panel-collapsed');
		        $this.removeClass('glyphicon-plus').addClass('glyphicon-minus');
		    }
		});
		$(document).on('focus', '.panel-footer input.chat_input', function (e) {
		    var $this = $(this);
		    if ($('#minim_chat_window').hasClass('panel-collapsed')) {
		        $this.parents('.panel').find('.panel-body').slideDown();
		        $('#minim_chat_window').removeClass('panel-collapsed');
		        $('#minim_chat_window').removeClass('glyphicon-plus').addClass('glyphicon-minus');
		    }
		});
		$(document).on('click', '#new_chat', function (e) {
		    var size = $( ".chat-window:last-child" ).css("margin-left");
		     size_total = parseInt(size) + 400;
		    alert(size_total);
		    var clone = $( "#chat_window_1" ).clone().appendTo( ".container" );
		    clone.css("margin-left", size_total);
		});
		/* $(document).on('click', '.icon_close', function (e) {
		    //$(this).parent().parent().parent().parent().remove();
		    $( "#chat_window_1" ).remove();
		}); */

	</script>
</body>
</html>