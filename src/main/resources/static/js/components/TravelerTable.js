class TravelerTable extends React.Component {

  createTable() {
    let table = [];
    var travelers = get();
    for (let i = 0; i < travelers.size(); i++) {
      table.push(<tr><td>{travelers.getName() + " $" + travelers.getExpense()}</td></tr>);
    }
    return table;
  }

  get() {
    console.log("get");
    fetch('/add', {
      credentials: 'same-origin',
      method: 'GET',
      headers: {
        'Content-Type': 'application/json'
      }
    });
    console.log("get end");
  }


  render() {
    return(
      <table>
        {this.createTable()}
      </table>
    )
  }

}
