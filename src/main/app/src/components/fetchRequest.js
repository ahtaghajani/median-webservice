import React from 'react';
import axios from 'axios';
import Pagination from "react-js-pagination";
import Request  from './request.js';

class FetchRequest extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      pageContent: [],
      activePage:1,
      totalPages: null,
      itemsCountPerPage:null,
      totalItemsCount:null
    };
    this.handlePageChange = this.handlePageChange.bind(this);
    this.fetchURL = this.fetchURL.bind(this);
  }

  fetchURL(page) {

    axios.get(`http://localhost:8080/requests?page=${page-1}&size=5`)
      .then( response => {

          const totalPages = response.data.totalPages;
          const itemsCountPerPage = response.data.size;
          const totalItemsCount = response.data.totalElements;

          this.setState({totalPages: totalPages})
          this.setState({totalItemsCount: totalItemsCount})
          this.setState({itemsCountPerPage: itemsCountPerPage})

          const content = response.data.content;

          const mappedContent = content.map(request => {

            var timestamp = new Date(request.dateTime)
            var dateString = timestamp.toGMTString()
            return {
                ...request, dateString
              }
            });

            this.setState({pageContent: mappedContent});
            console.log(mappedContent);
            console.log(this.state.activePage);
            console.log(this.state.itemsCountPerPage);

        }
      );
    }

  componentDidMount () {
      this.fetchURL(this.state.activePage)
    }

  handlePageChange(pageNumber) {
    console.log(`active page is ${pageNumber}`);
    this.setState({activePage: pageNumber})
    this.fetchURL(pageNumber)

    }

  populateRowsWithData = () => {
    const requestData = this.state.pageContent.map(request => {
        return <Request
            id = {request.id}
            dateString = {request.dateString}
            dateTime = {request.dateTime}
            rawContent = {request.rawContent}
            contentMedianByLabel = {request.contentMedianByLabel}
          />;
      });

      return requestData
    }

  render(){

    return (
      <div >

      {this.populateRowsWithData()}

      <div className="d-flex justify-content-center">
        <Pagination
         hideNavigation
         activePage={this.state.activePage}
         itemsCountPerPage={this.state.itemsCountPerPage}
         totalItemsCount={this.state.totalItemsCount}
         pageRangeDisplayed={10}
         itemClass='page-item'
         linkClass='btn btn-light'
         onChange={this.handlePageChange}
         />
       </div>
      </div>
    );
  }
}

export default FetchRequest;
