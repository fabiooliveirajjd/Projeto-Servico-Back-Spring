package com.fabio.projeto.enuns;

public enum Tipo {
	FERRAMENTA(0, "FERRAMENTA"), 
	PECA(1, "PECA"), 
	OUTRO(2, "OUTRO");

		private Integer codigo;
		private String descricao;

		private Tipo(Integer codigo, String descricao) {
			this.codigo = codigo;
			this.descricao = descricao;
		}

		public Integer getCodigo() {
			return codigo;
		}

		public String getDescricao() {
			return descricao;
		}
		public static Tipo toEnum(Integer cod) {
			if (cod == null) {
				return null;
			}
			for (Tipo x : Tipo.values()) {
				if (cod.equals(x.getCodigo())) {
					return x;
				}

			}
			throw new IllegalArgumentException("Status inválido");
		}
}
