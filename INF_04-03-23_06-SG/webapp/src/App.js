import 'bootstrap/dist/css/bootstrap.css';
import './App.css'

function App() {
  const movieTypes = [
    { id: 1, name: 'Komedia' },
    { id: 2, name: 'Obyczajowy' },
    { id: 3, name: 'Sensacyjny' },
    { id: 4, name: 'Horror' }
  ];

  function handleSubmit(e) {
    e.preventDefault();
    console.log(`tytul: ${e.target.title.value}; rodzaj: ${e.target.type.value}`);
  }
  return (
      <div className="">
        <form onSubmit={(e) => handleSubmit(e)}>
          <div className="form-group">
            <label htmlFor="movieTitle">Tytuł filmu</label>
            <input name="title" type="text" className="form-control" id="movieTitle"/>
          </div>
          <div className="form-group">
            <label htmlFor="movieType">Rodzaj</label>
            <select name="type" className="form-control" id="movieType">
              <option value="0" selected={true}></option>
              {movieTypes.map(type => (
                  <option key={type.id} value={type.id}>{type.name}</option>
              ))}
            </select>
          </div>
          <button type="submit" className="btn btn-primary mt-2">Dodaj</button>
        </form>
      </div>
  );
}

export default App;
