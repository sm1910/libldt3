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
import libldt3.model.enums.Diagnosesicherheit;
import libldt3.model.enums.Lokalisation;
import libldt3.model.regel.F004;
import lombok.Getter;
import lombok.Setter;

/**
 * Mit diesem Objekt können Angaben zu Diagnosen des Patienten übertragen werden.
 */
@Objekt("0100")
public @Getter @Setter class Diagnose {

	@Feld(value = "4207", feldart = Feldart.kann)
	@Regelsatz(maxLaenge = 60)
	private List<String> diagnoseVerdachtsdiagnose;
	@Feld(value = "6001", feldart = Feldart.bedingt_muss)
	@Regelsatz(F004.class)
	private String icdCode;
	@Feld(value = "6003", feldart = Feldart.bedingt_kann)
	@Regelsatz(laenge = 1)
	private Diagnosesicherheit diagnosesicherheit;
	@Feld(value = "6004", feldart = Feldart.bedingt_kann)
	@Regelsatz(laenge = 1)
	private Lokalisation lokalisation;
	@Feld(value = "6006", feldart = Feldart.bedingt_kann)
	@Regelsatz(maxLaenge = 60)
	private List<String> erlaeuterung;
	@Feld(value = "6008", feldart = Feldart.bedingt_kann)
	@Regelsatz(maxLaenge = 60)
	private List<String> ausnahmetatbestand;

}
