import 'bootstrap/dist/css/bootstrap.css';

function App() {
  const courses = ['Programowanie w C#', 'Angular dla początkujących', 'Kurs Django']

  function handleSubmit(event) {
    event.preventDefault()
    console.log(event.target.name.value)
    console.log(courses[event.target.courseNumber.value] ?? 'Nieprawidłowy numer kursu');
  }

  return (
    <div className="container">
      <h2>Liczba kursów: {courses.length}</h2>
      <ol>
        {courses.map((course, i) => <li key={i}>{course}</li>)}
      </ol>
      <form onSubmit={handleSubmit}>
        <div className="form-group mb-3">
          <label htmlFor="name_field">Imie i nazwisko</label>
          <input type="text" className="form-control" name="name" id="name_field"/>
        </div>
        <div className="form-group mb-3">
          <label htmlFor="course_number_field">Numer kursu</label>
          <input type="number" className="form-control" name="courseNumber" id="course_number_field"/>
        </div>
        <button type="submit" className="btn btn-primary">Zapisz do kursu</button>
      </form>
    </div>
  );
}

export default App;
