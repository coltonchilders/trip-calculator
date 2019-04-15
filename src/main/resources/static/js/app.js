var App = React.createClass({
  render: function() {
    return (
      <ExpenseForm />
    );
  }
});

ReactDOM.render(<App />, document.getElementById("app"));
