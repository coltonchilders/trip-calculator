class Result extends React.Component {
  controller(props) {
    super(props);
  }

  calculate() {
    fetch('/calculate', {
      credentials: 'same-origin',
      method: 'GET',
      headers: {
        'Content-Type': 'application/json'
      }
    });
  }

  render() {
    return {
      <h2>{this.calculate}</h2>
    }
  }
}
