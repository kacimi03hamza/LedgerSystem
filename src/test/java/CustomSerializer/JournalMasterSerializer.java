package CustomSerializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.criteria.Root;

import org.assertj.core.util.Lists;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.mediasoft.odeks.model.AccountChart;
import com.mediasoft.odeks.model.AccountSubledger;
import com.mediasoft.odeks.model.AgreementInformation;
import com.mediasoft.odeks.model.Contractor;
import com.mediasoft.odeks.model.CostCenterDetails;
import com.mediasoft.odeks.model.DevelopmentPartnerInformation;
import com.mediasoft.odeks.model.Employe;
import com.mediasoft.odeks.model.JournalDetail;
import com.mediasoft.odeks.model.JournalMaster;
import com.mediasoft.odeks.model.ProjectIdentifier;
import com.mediasoft.odeks.model.Supplier;
public class JournalMasterSerializer extends JsonSerializer<JournalMaster> {

	@Override
	public void serialize(JournalMaster value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
//		try {
//		gen.writeStartObject();
//		gen.writeNumberField("id", value.getId());
//		gen.writeStringField("journalNumber", value.getJournalNumber());
//		gen.writeStringField("temporaryNumber", value.getTemporaryNumber());
//		gen.writeStringField("journalDate", new SimpleDateFormat().format(value.getJournalDate()));
//		gen.writeStringField("financialYear", value.getFinancialYear());
//		gen.writeStringField("journalSource", value.getJournalSource());
//		gen.writeStringField("narration", value.getNarration());
//		gen.writeStringField("entryDateTime", value.getEntryDateTime());
//		gen.writeStringField("journalStatus", value.getJournalStatus());
//		gen.writeStringField("submitDateTime", new SimpleDateFormat().format(value.getSubmitDateTime()));
//		gen.writeStringField("isApproved", value.getIsApproved());
//		gen.writeStringField("approvedDate", new SimpleDateFormat().format(value.getApprovedDate()));
//		gen.writeStringField("approvedby", value.getApprovedby());
//		gen.writeArrayFieldStart("journalDetails");
//		gen.writeStartArray(value.getJournalDetail().size());
//		ObjectMapper obMapp=new ObjectMapper();
//		obMapp.
//		gen.writeEndArray();
//		gen.writeEndObject();
//		}catch(Exception e) {
//			System.out.println(e.getMessage());
//		}
	}

	
}
