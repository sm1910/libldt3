/*
 * Copyright 2016  Christoph Brill <egore911@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package libldt3.model.objekte;

import java.util.List;

import libldt3.annotations.Feld;
import libldt3.annotations.Feldart;
import libldt3.annotations.Objekt;
import libldt3.annotations.Regelsatz;
import libldt3.model.enums.Befundtyp;
import libldt3.model.enums.ZusaetzlicherBefundweg;
import lombok.Getter;
import lombok.Setter;

/**
 * Dieses Objekt bündelt alle Daten zum Befund inklusive aller Kennungen, welche
 * eine eineindeutige Zuordnung von Auftrag und Befund sicherstellen.
 */
@Objekt("0017")
public @Getter @Setter class Befundinformationen {

	@Objekt
	public static @Getter @Setter class OrderNumber {
		@SuppressWarnings("unused")
		private String value;
		@Feld(value = "8313", feldart = Feldart.bedingt_kann, regelsaetze = @Regelsatz(maxLaenge = 60))
		private List<String> nachforderungId;
		@Feld(value = "8214", name = "Timestamp_Auftragserteilung", feldart = Feldart.bedingt_kann, regelsaetze = @Regelsatz(laenge = 27))
		private Timestamp orderRequestTimestamp;
		@Feld(value = "8215", name = "Timestamp_Auftragseingang", feldart = Feldart.bedingt_kann, regelsaetze = @Regelsatz(laenge = 25))
		private Timestamp timestampAuftragseingang;
	}
	
	@Objekt
	public static @Getter @Setter class Befundweg {
		@SuppressWarnings("unused")
		private ZusaetzlicherBefundweg value;
		@Feld(value = "8147", feldart = Feldart.bedingt_muss, regelsaetze = @Regelsatz(laenge = 6))
		private Person person;
	}

	@Feld(value = "8310", feldart = Feldart.muss, regelsaetze = @Regelsatz(maxLaenge = 60))
	private OrderNumber orderNumber;
	@Feld(value = "8311", feldart = Feldart.muss, regelsaetze = @Regelsatz(maxLaenge = 60))
	private String orderId;
	@Feld(value = "7305", feldart = Feldart.bedingt_muss, regelsaetze = @Regelsatz(maxLaenge = 60))
	private String findingId;
	@Feld(value = "8401", feldart = Feldart.bedingt_muss, regelsaetze = @Regelsatz(laenge = 1))
	private Befundtyp type;
	@Feld(value = "0080", feldart = Feldart.kann, regelsaetze = @Regelsatz(maxLaenge = 60))
	private String fallakteId;
	@Feld(value = "0081", feldart = Feldart.bedingt_kann, regelsaetze = @Regelsatz(maxLaenge = 60))
	private List<String> fallakteBezeichnung;
	@Feld(value = "7258", feldart = Feldart.kann, regelsaetze = @Regelsatz(maxLaenge = 60))
	private String katalogId;
	@Feld(value = "7251", feldart = Feldart.bedingt_kann, regelsaetze = @Regelsatz(maxLaenge = 60))
	private String katalogBezeichnung;
	@Feld(value = "4229", feldart = Feldart.kann, regelsaetze = @Regelsatz(laenge = 5))
	private List<String> ausnahmeindikation;
	@Feld(value = "7308", feldart = Feldart.bedingt_muss, regelsaetze = @Regelsatz(minLaenge = 1, maxLaenge = 2))
	private Integer anzahlLaborergebnisberichte;
	@Feld(value = "8118", name = "Abweichender_Befundweg", feldart = Feldart.kann, regelsaetze = @Regelsatz(laenge = 22))
	private Kommunikationsdaten abweichenderBefundweg;
	@Feld(value = "8611", feldart = Feldart.bedingt_kann, regelsaetze = @Regelsatz(laenge = 1))
	private List<Befundweg> zusaetzlicherBefundweg;
	@Feld(value = "7320", feldart = Feldart.kann, regelsaetze = @Regelsatz(laenge = 1))
	private Boolean recallEmpfohlen;
	@Feld(value = "8154", feldart = Feldart.bedingt_kann, regelsaetze = @Regelsatz(laenge = 9))
	private Timestamp recallEmpfohlenTimestamp;
	@Feld(value = "8216", name = "Timestamp_Befunderstellung", feldart = Feldart.muss, regelsaetze = @Regelsatz(laenge = 26))
	private Timestamp timestampBefunderstellung;
	@Feld(value = "8167", name = "Zusaetzliche_Informationen", feldart = Feldart.kann, regelsaetze = @Regelsatz(laenge = 26))
	private List<Fliesstext> zusaetzlicheInformationen;
	@Feld(value = "8110", feldart = Feldart.kann, regelsaetze = @Regelsatz(laenge = 6))
	private List<Anhang> anhang;
	@Feld(value = "8126", name = "Fehlermeldung_Aufmerksamkeit", feldart = Feldart.bedingt_muss, regelsaetze = @Regelsatz(laenge = 28))
	private FehlermeldungAufmerksamkeit fehlermeldungAufmerksamkeit;
	@Feld(value = "8141", feldart = Feldart.kann, regelsaetze = @Regelsatz(laenge = 13))
	private Namenskennung namenskennung;

}
