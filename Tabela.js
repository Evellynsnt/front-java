function Tabela() {
    return (
      <table>
        <thead>
          <tr>
            <th>#</th>
            <th>Nome</th>
            <th>Marca</th>
            <th>Selecionar</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>1</td>
            <td>Nome 1</td>
            <td>Marca 1</td>
            <td>
              <input type="radio" name="selecionar" value="1" />
            </td>
          </tr>
          <tr>
            <td>2</td>
            <td>Nome 2</td>
            <td>Marca 2</td>
            <td>
              <input type="radio" name="selecionar" value="2" />
            </td>
          </tr>
        </tbody>
      </table>
    );
}

export default Tabela;
