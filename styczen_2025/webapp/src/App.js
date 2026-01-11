import {useState} from "react";

function App() {
  const [categories, setCategories] = useState([1,2,3]);

  const [images, setImages] = useState([
    {id: 0, alt: "Mak", filename: "obraz1.jpg", category:1, downloads: 35},
    {id: 1, alt:"Bukiet", filename: "obraz2.jpg", category: 1, downloads: 43},
    {id: 2, alt:"Dalmatyńczyk", filename: "obraz3.jpg", category:2, downloads: 2},
    {id: 3, alt:"Świnka morska", filename: "obraz4.jpg", category:2, downloads: 53},
    {id: 4, alt:"Rotwailer", filename: "obraz5.jpg", category:2, downloads: 43},
    {id: 5, alt:"Audi", filename: "obraz6.jpg", category:3, downloads: 11},
    {id: 6, alt:"kotki", filename: "obraz7.jpg", category:2, downloads: 22},
    {id: 7, alt:"Róża", filename: "obraz8.jpg", category:1, downloads: 33},
    {id: 8, alt:"Świnka morska", filename: "obraz9.jpg", category:2, downloads: 123},
    {id: 9, alt:"Foksterier", filename: "obraz10.jpg", category:2, downloads: 22},
    {id: 10, alt:"Szczeniak", filename: "obraz11.jpg", category:2, downloads: 12},
    {id: 11, alt:"Garbus", filename: "obraz12.jpg", category:3, downloads: 321}
  ]);

  /**
   * nazwa funkcji:       toggleCategory
   * opis funkcji:        aktywuje lub deaktywuje dana kategorie
   * parametry:           categoryId - id kategori
   * zwracany typ i opis: brak
   * autor:               00000000000
   */
  function toggleCategory(categoryId) {
    if (categories.includes(categoryId)) setCategories(categories.filter(it => it !== categoryId));
    else setCategories([...categories, categoryId])
  }

  return (
    <div className="container">
      <h1>Kategorie zdjęć</h1>
      <div className="d-flex align-items-center">
        <div className="form-check form-switch me-3">
          <input className="form-check-input" type="checkbox" checked={categories.includes(1)} onChange={() => toggleCategory(1)} id="ctrId"/>
          <label className="form-check-label" htmlFor="ctrId">Kwiaty</label>
        </div>
        <div className="form-check form-switch me-3">
          <input className="form-check-input" type="checkbox" checked={categories.includes(2)} onChange={() => toggleCategory(2)} id="ctrId2"/>
          <label className="form-check-label" htmlFor="ctrId2">Zwierzęta</label>
        </div>
        <div className="form-check form-switch">
          <input className="form-check-input" type="checkbox" checked={categories.includes(3)} onChange={() => toggleCategory(3)} id="ctrId3"/>
          <label className="form-check-label" htmlFor="ctrId3">Samochody</label>
        </div>
      </div>
      <div className="container">
        <div className="row row-cols-3 g-4">
          {images.filter(it => categories.includes(it.category)).map(image => (
            <div className="col">
              <img className="rounded" style={{ margin: "5px" }} src={require(`./assets/${image.filename}`)} alt={image.alt}/>
              <h4>Pobrań: {image.downloads}</h4>
              <button type="button" className="btn btn-success col" onClick={() => {
                setImages(images.map(img => img.id === image.id ? { ...img, downloads: img.downloads + 1 } : img))
              }}>Pobierz</button>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
}

export default App;
