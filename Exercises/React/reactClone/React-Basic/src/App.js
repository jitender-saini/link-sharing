import React from 'react';
import './style/style.css';
import './style/bootstrap.min.css';
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
    this.Click = this.onClick.bind(this);
  }

  onClick(e) {
    setTimeout(() => {
      this.setState({
        count: this.state.count + 1
      });
    }, 1000);
  }

  render() {
    const { count } = this.state;
    return (
      <div className="container">
        <Header/>
        <NavPanel count={count}/>
        <Content onClick={this.Click}/>
        <Footer/>
      </div>
    )
  };
}

