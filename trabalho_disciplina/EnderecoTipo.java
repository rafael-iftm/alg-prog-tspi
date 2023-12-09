package trabalho_disciplina;

import java.util.ArrayList;

public class EnderecoTipo {
    private static ArrayList<String> tiposEndereco = new ArrayList<>();

    public static void adicionarTipoEndereco(String tipoEndereco) {
        tiposEndereco.add(tipoEndereco);
    }

    public static ArrayList<String> getTiposEndereco() {
        return tiposEndereco;
    }
}
