package com.example.relatoriosFrota.enuns;

public enum Filial {

    MATRIZ("1 - MATRIZ", "MATRIZ"),

    AQUIDAUANA_ANASTACIO(
            "2 - AQUIDAUANA/ANASTACIO",
            "AQUID./ ANASTÁCIO"
    ),

    DOIS_IRMAOS_BURITI(
            "3 - D.I.B",
            "DOIS IRMÃOS BURITI"
    ),

    NIOAQUE(
            "4 - NIOAQUE",
            "NIOAQUE"
    ),

    JARDIM_GUIA_LOPES(
            "5 - JARDIM/GUIA LOPES",
            "JARDIM / GUIA LOPES"
    ),

    BONITO(
            "7 - BONITO",
            "BONITO"
    ),

    BODOQUENA(
            "15 - BODOQUENA",
            "BODOQUENA"
    );

    private final String titulo;
    private final String nomeRelatorio;

    Filial(String titulo, String nomeRelatorio) {
        this.titulo = titulo;
        this.nomeRelatorio = nomeRelatorio;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getNomeRelatorio() {
        return nomeRelatorio;
    }
}
