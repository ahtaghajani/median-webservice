(window.webpackJsonp=window.webpackJsonp||[]).push([[0],{23:function(e,t,a){e.exports=a(52)},28:function(e,t,a){},29:function(e,t,a){},52:function(e,t,a){"use strict";a.r(t);var n=a(0),o=a.n(n),i=a(19),c=a.n(i),l=(a(28),a(3)),r=a(4),s=a(6),u=a(5),m=a(7),d=(a(29),function(){return o.a.createElement("div",{className:"jumbotron "},o.a.createElement("div",{className:"container "},o.a.createElement("h1",{className:"display-4 "},"React Pagination Demo"),o.a.createElement("p",{className:"lead"},"It\u2019s important to limit the amount of data queried by your API in a request.")))}),g=a(22),h=a(2),v=a(20),f=a.n(v),p=a(21),b=a.n(p);var P=function(e){return o.a.createElement("div",{className:"card border-dark bg-light text-dark text-center p-3 mb-3 ml-5 mr-5",style:{maxWidth:"700px"}},o.a.createElement("div",{className:"card-header"},o.a.createElement("h2",null,e.id),JSON.stringify(e)))},C=function(e){function t(e){var a;return Object(l.a)(this,t),(a=Object(s.a)(this,Object(u.a)(t).call(this,e))).populateRowsWithData=function(){return a.state.pageContent.map(function(e){return o.a.createElement(P,{id:e.id,dateString:e.dateString,dateTime:e.dateTime,rawContent:e.rawContent,contentMedianByLabel:e.contentMedianByLabel})})},a.state={pageContent:[],activePage:1,totalPages:null,itemsCountPerPage:null,totalItemsCount:null},a.handlePageChange=a.handlePageChange.bind(Object(h.a)(a)),a.fetchURL=a.fetchURL.bind(Object(h.a)(a)),a}return Object(m.a)(t,e),Object(r.a)(t,[{key:"fetchURL",value:function(e){var t=this;f.a.get("http://localhost:8080/requests?page=".concat(e-1,"&size=5")).then(function(e){var a=e.data.totalPages,n=e.data.size,o=e.data.totalElements;t.setState({totalPages:a}),t.setState({totalItemsCount:o}),t.setState({itemsCountPerPage:n});var i=e.data.content.map(function(e){var t=new Date(e.dateTime).toGMTString();return Object(g.a)({},e,{dateString:t})});t.setState({pageContent:i}),console.log(i),console.log(t.state.activePage),console.log(t.state.itemsCountPerPage)})}},{key:"componentDidMount",value:function(){this.fetchURL(this.state.activePage)}},{key:"handlePageChange",value:function(e){console.log("active page is ".concat(e)),this.setState({activePage:e}),this.fetchURL(e)}},{key:"render",value:function(){return o.a.createElement("div",null,this.populateRowsWithData(),o.a.createElement("div",{className:"d-flex justify-content-center"},o.a.createElement(b.a,{hideNavigation:!0,activePage:this.state.activePage,itemsCountPerPage:this.state.itemsCountPerPage,totalItemsCount:this.state.totalItemsCount,pageRangeDisplayed:10,itemClass:"page-item",linkClass:"btn btn-light",onChange:this.handlePageChange})))}}]),t}(o.a.Component),y=function(e){function t(){return Object(l.a)(this,t),Object(s.a)(this,Object(u.a)(t).apply(this,arguments))}return Object(m.a)(t,e),Object(r.a)(t,[{key:"render",value:function(){return o.a.createElement("div",null,o.a.createElement(d,null),o.a.createElement("div",{className:"d-flex justify-content-center"},o.a.createElement(C,null)))}}]),t}(n.Component);a(51),Boolean("localhost"===window.location.hostname||"[::1]"===window.location.hostname||window.location.hostname.match(/^127(?:\.(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)){3}$/));c.a.render(o.a.createElement(y,null),document.getElementById("root")),"serviceWorker"in navigator&&navigator.serviceWorker.ready.then(function(e){e.unregister()})}},[[23,1,2]]]);
//# sourceMappingURL=main.03f12209.chunk.js.map