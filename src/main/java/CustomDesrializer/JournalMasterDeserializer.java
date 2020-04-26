package CustomDesrializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
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
public class JournalMasterDeserializer extends JsonDeserializer<JournalMaster> {

	@Override
	public JournalMaster deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
			ObjectCodec oc = p.getCodec();
		     JsonNode node = oc.readTree(p);
		     Iterator<JsonNode> iterator=node.get("journalDetail").elements();
		     JournalMaster master=new JournalMaster();
		     while(iterator.hasNext()) {
		    	 JsonNode  next=iterator.next();
		    	 JournalDetail journalDetail=new JournalDetail();
		    	 if(next.get("id") != null) {
		    		 journalDetail.setId(next.get("id").asInt()); 
		    	 }
		    	 AccountChart accountChart=new AccountChart();
		    	 accountChart.setLedgercode(next.get("accountChart").get("code").asText());
		    	 AccountSubledger accountSubLedger=new AccountSubledger();
		    	 journalDetail.setAccountChart(accountChart);
		    	 accountSubLedger.setLedgerCode(next.get("accountSubLedger").get("code").asText());
		    	 journalDetail.setAccountSubLedger(accountSubLedger);
		    	 CostCenterDetails costCenterDetail=new CostCenterDetails();
		    	 costCenterDetail.setCostCenterCode(next.get("costCenterDetail").get("code").asText());
		    	 journalDetail.setCostCenterDetail(costCenterDetail);
		    	 ProjectIdentifier projectIdentifier=new ProjectIdentifier();
		    	 projectIdentifier.setProjectCode(next.get("projectIdentifeir").get("code").asText());
		    	 journalDetail.setProjectIdentifeir(projectIdentifier);
		    	 DevelopmentPartnerInformation devloPatnerInformation=new DevelopmentPartnerInformation();
		    	 devloPatnerInformation.setDevPartnerCode(next.get("devParternInfo").get("code").asText());
		    	 journalDetail.setDevParternInfo(devloPatnerInformation);
		    	 AgreementInformation agrementInfo=new AgreementInformation();
		    	 agrementInfo.setAgreementCode(next.get("agreementInfo").get("code").asText());
		    	 journalDetail.setAgreementInfo(agrementInfo);
		    	 Employe employe=new Employe();
		    	 employe.setCode(next.get("employe").get("code").asText());
		    	 journalDetail.setEmploye(employe);
		    	 Supplier supplier=new Supplier();
		    	 journalDetail.setSupplier(supplier);
		    	 supplier.setCode(next.get("supplier").get("code").asText());
		    	 Contractor contractor=new Contractor();
		    	 contractor.setCode(next.get("contractor").get("code").asText());
		    	 journalDetail.setContractor(contractor);
		    	 journalDetail.setDebitAmount(next.get("debitAmount").asDouble());
		    	 journalDetail.setCreditAmount(next.get("creditAmount").asDouble());
		    	 master.getJournalDetail().add(journalDetail);
		     }
		     if(node.get("id")!=null) {
		    	 master.setId(node.get("id").asInt()); 
		     }
		     master.setFinancialYear(node.get("financialYear").asText());
		     if(node.get("temporaryNumber")!=null) {
		    	 master.setTemporaryNumber(node.get("temporaryNumber").asText()); 
		     }
		     
		     Date journalDate=new Date();
		     SimpleDateFormat simpleDateFormater=new SimpleDateFormat("dd/MM/yyyy");
		     try {
				journalDate=simpleDateFormater.parse(node.get("journalDate").asText());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		     master.setJournalDate(journalDate);
			return master;
		
	}

}
