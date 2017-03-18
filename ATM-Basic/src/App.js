import React from 'react';
import './style.css';
import Header from './Header';
import NavPanel from './NavPanel';
import Content from './Content';
import Footer from './Footer';

export default class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      count: 0

    };
  }

  onClick(e) {
    setTimeout(() => {
      this.setState({
        count: this.state.count + 1
      });
    }, 1000);
  }

  render() {
    return (
      <div className="container">
        <Header/>
        <NavPanel count={this.state.count}/>
        <Content onClick={this.onClick.bind(this)}/>
        <Footer/>
      </div>
    )
  };
}

