package dominio.frete;

import java.util.List;

public class FreteFactory {
    public static List<Frete> criarFretes() {
        return List.of(
                new FreteGratis(200)
        );
    }
}