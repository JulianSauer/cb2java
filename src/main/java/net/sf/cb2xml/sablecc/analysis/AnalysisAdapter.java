/* This file was generated by SableCC (http://www.sablecc.org/). */

package net.sf.cb2xml.sablecc.analysis;

import net.sf.cb2xml.sablecc.node.*;

import java.util.Hashtable;

public class AnalysisAdapter implements Analysis {
    private Hashtable in;
    private Hashtable out;

    public Object getIn(Node node) {
        if (in == null) {
            return null;
        }

        return in.get(node);
    }

    public void setIn(Node node, Object in) {
        if (this.in == null) {
            this.in = new Hashtable(1);
        }

        if (in != null) {
            this.in.put(node, in);
        } else {
            this.in.remove(node);
        }
    }

    public Object getOut(Node node) {
        if (out == null) {
            return null;
        }

        return out.get(node);
    }

    public void setOut(Node node, Object out) {
        if (this.out == null) {
            this.out = new Hashtable(1);
        }

        if (out != null) {
            this.out.put(node, out);
        } else {
            this.out.remove(node);
        }
    }

    public void caseStart(Start node) {
        defaultCase(node);
    }

    public void caseARecordDescription(ARecordDescription node) {
        defaultCase(node);
    }

    public void caseASingleGroupItem(ASingleGroupItem node) {
        defaultCase(node);
    }

    public void caseASequenceGroupItem(ASequenceGroupItem node) {
        defaultCase(node);
    }

    public void caseAItemElementaryItem(AItemElementaryItem node) {
        defaultCase(node);
    }

    public void caseARenamesItemElementaryItem(ARenamesItemElementaryItem node) {
        defaultCase(node);
    }

    public void caseAValueItemElementaryItem(AValueItemElementaryItem node) {
        defaultCase(node);
    }

    public void caseAItem(AItem node) {
        defaultCase(node);
    }

    public void caseADataNameDataNameOrFiller(ADataNameDataNameOrFiller node) {
        defaultCase(node);
    }

    public void caseAFillerDataNameOrFiller(AFillerDataNameOrFiller node) {
        defaultCase(node);
    }

    public void caseARedefinesClause(ARedefinesClause node) {
        defaultCase(node);
    }

    public void caseASingleClauseSequence(ASingleClauseSequence node) {
        defaultCase(node);
    }

    public void caseASequenceClauseSequence(ASequenceClauseSequence node) {
        defaultCase(node);
    }

    public void caseABlankWhenZeroClauseClause(ABlankWhenZeroClauseClause node) {
        defaultCase(node);
    }

    public void caseADateFormatClauseClause(ADateFormatClauseClause node) {
        defaultCase(node);
    }

    public void caseAExternalClauseClause(AExternalClauseClause node) {
        defaultCase(node);
    }

    public void caseAGlobalClauseClause(AGlobalClauseClause node) {
        defaultCase(node);
    }

    public void caseAJustifiedClauseClause(AJustifiedClauseClause node) {
        defaultCase(node);
    }

    public void caseAOccursClauseClause(AOccursClauseClause node) {
        defaultCase(node);
    }

    public void caseAPictureClauseClause(APictureClauseClause node) {
        defaultCase(node);
    }

    public void caseASignClauseClause(ASignClauseClause node) {
        defaultCase(node);
    }

    public void caseASynchronizedClauseClause(ASynchronizedClauseClause node) {
        defaultCase(node);
    }

    public void caseAUsageClauseClause(AUsageClauseClause node) {
        defaultCase(node);
    }

    public void caseAValueClauseClause(AValueClauseClause node) {
        defaultCase(node);
    }

    public void caseABlankWhenZeroClause(ABlankWhenZeroClause node) {
        defaultCase(node);
    }

    public void caseADateFormatClause(ADateFormatClause node) {
        defaultCase(node);
    }

    public void caseAExternalClause(AExternalClause node) {
        defaultCase(node);
    }

    public void caseAGlobalClause(AGlobalClause node) {
        defaultCase(node);
    }

    public void caseAJustifiedClause(AJustifiedClause node) {
        defaultCase(node);
    }

    public void caseAOccursClause(AOccursClause node) {
        defaultCase(node);
    }

    public void caseAFixedOccursFixedOrVariable(AFixedOccursFixedOrVariable node) {
        defaultCase(node);
    }

    public void caseAVariableOccursFixedOrVariable(AVariableOccursFixedOrVariable node) {
        defaultCase(node);
    }

    public void caseAOccursTo(AOccursTo node) {
        defaultCase(node);
    }

    public void caseAAscendingOrDescendingKeyPhrase(AAscendingOrDescendingKeyPhrase node) {
        defaultCase(node);
    }

    public void caseAAscendingAscendingOrDescending(AAscendingAscendingOrDescending node) {
        defaultCase(node);
    }

    public void caseADescendingAscendingOrDescending(ADescendingAscendingOrDescending node) {
        defaultCase(node);
    }

    public void caseAIndexedByPhrase(AIndexedByPhrase node) {
        defaultCase(node);
    }

    public void caseAPictureClause(APictureClause node) {
        defaultCase(node);
    }

    public void caseASignClause(ASignClause node) {
        defaultCase(node);
    }

    public void caseASignIs(ASignIs node) {
        defaultCase(node);
    }

    public void caseALeadingLeadingOrTrailing(ALeadingLeadingOrTrailing node) {
        defaultCase(node);
    }

    public void caseATrailingLeadingOrTrailing(ATrailingLeadingOrTrailing node) {
        defaultCase(node);
    }

    public void caseASeparateCharacter(ASeparateCharacter node) {
        defaultCase(node);
    }

    public void caseASynchronizedClause(ASynchronizedClause node) {
        defaultCase(node);
    }

    public void caseALeftLeftOrRight(ALeftLeftOrRight node) {
        defaultCase(node);
    }

    public void caseARightLeftOrRight(ARightLeftOrRight node) {
        defaultCase(node);
    }

    public void caseAUsageClause(AUsageClause node) {
        defaultCase(node);
    }

    public void caseAUsageIs(AUsageIs node) {
        defaultCase(node);
    }

    public void caseABinaryUsagePhrase(ABinaryUsagePhrase node) {
        defaultCase(node);
    }

    public void caseACompUsagePhrase(ACompUsagePhrase node) {
        defaultCase(node);
    }

    public void caseAComp1UsagePhrase(AComp1UsagePhrase node) {
        defaultCase(node);
    }

    public void caseAComp2UsagePhrase(AComp2UsagePhrase node) {
        defaultCase(node);
    }

    public void caseAComp3UsagePhrase(AComp3UsagePhrase node) {
        defaultCase(node);
    }

    public void caseAComp4UsagePhrase(AComp4UsagePhrase node) {
        defaultCase(node);
    }

    public void caseAComp5UsagePhrase(AComp5UsagePhrase node) {
        defaultCase(node);
    }

    public void caseADisplayUsagePhrase(ADisplayUsagePhrase node) {
        defaultCase(node);
    }

    public void caseADisplay1UsagePhrase(ADisplay1UsagePhrase node) {
        defaultCase(node);
    }

    public void caseAIndexUsagePhrase(AIndexUsagePhrase node) {
        defaultCase(node);
    }

    public void caseANationalUsagePhrase(ANationalUsagePhrase node) {
        defaultCase(node);
    }

    public void caseAObjectReferencePhraseUsagePhrase(AObjectReferencePhraseUsagePhrase node) {
        defaultCase(node);
    }

    public void caseAPackedDecimalUsagePhrase(APackedDecimalUsagePhrase node) {
        defaultCase(node);
    }

    public void caseAPointerUsagePhrase(APointerUsagePhrase node) {
        defaultCase(node);
    }

    public void caseAProcedurePointerUsagePhrase(AProcedurePointerUsagePhrase node) {
        defaultCase(node);
    }

    public void caseAFunctionPointerUsagePhrase(AFunctionPointerUsagePhrase node) {
        defaultCase(node);
    }

    public void caseAObjectReferencePhrase(AObjectReferencePhrase node) {
        defaultCase(node);
    }

    public void caseARenamesItem(ARenamesItem node) {
        defaultCase(node);
    }

    public void caseAThroughPhrase(AThroughPhrase node) {
        defaultCase(node);
    }

    public void caseAValueClause(AValueClause node) {
        defaultCase(node);
    }

    public void caseAValueItem(AValueItem node) {
        defaultCase(node);
    }

    public void caseAValueValueOrValues(AValueValueOrValues node) {
        defaultCase(node);
    }

    public void caseAValuesValueOrValues(AValuesValueOrValues node) {
        defaultCase(node);
    }

    public void caseASingleLiteralSequence(ASingleLiteralSequence node) {
        defaultCase(node);
    }

    public void caseASequenceLiteralSequence(ASequenceLiteralSequence node) {
        defaultCase(node);
    }

    public void caseAThroughSingleLiteralSequence(AThroughSingleLiteralSequence node) {
        defaultCase(node);
    }

    public void caseAThroughSequenceLiteralSequence(AThroughSequenceLiteralSequence node) {
        defaultCase(node);
    }

    public void caseAZerosLiteral(AZerosLiteral node) {
        defaultCase(node);
    }

    public void caseASpacesLiteral(ASpacesLiteral node) {
        defaultCase(node);
    }

    public void caseAHighValuesLiteral(AHighValuesLiteral node) {
        defaultCase(node);
    }

    public void caseALowValuesLiteral(ALowValuesLiteral node) {
        defaultCase(node);
    }

    public void caseAQuotesLiteral(AQuotesLiteral node) {
        defaultCase(node);
    }

    public void caseANullsLiteral(ANullsLiteral node) {
        defaultCase(node);
    }

    public void caseANumberLiteral(ANumberLiteral node) {
        defaultCase(node);
    }

    public void caseANumericLiteralLiteral(ANumericLiteralLiteral node) {
        defaultCase(node);
    }

    public void caseAAlphanumericLiteralLiteral(AAlphanumericLiteralLiteral node) {
        defaultCase(node);
    }

    public void caseASingleCharacterString(ASingleCharacterString node) {
        defaultCase(node);
    }

    public void caseASequenceCharacterString(ASequenceCharacterString node) {
        defaultCase(node);
    }

    public void caseADataNameCharacterSubstring(ADataNameCharacterSubstring node) {
        defaultCase(node);
    }

    public void caseAPlusCharacterSubstring(APlusCharacterSubstring node) {
        defaultCase(node);
    }

    public void caseAMinusCharacterSubstring(AMinusCharacterSubstring node) {
        defaultCase(node);
    }

    public void caseAStarCharacterSubstring(AStarCharacterSubstring node) {
        defaultCase(node);
    }

    public void caseASlashCharacterSubstring(ASlashCharacterSubstring node) {
        defaultCase(node);
    }

    public void caseADollarCharacterSubstring(ADollarCharacterSubstring node) {
        defaultCase(node);
    }

    public void caseACommaCharacterSubstring(ACommaCharacterSubstring node) {
        defaultCase(node);
    }

    public void caseANumberCharacterSubstring(ANumberCharacterSubstring node) {
        defaultCase(node);
    }

    public void caseANumericLiteralCharacterSubstring(ANumericLiteralCharacterSubstring node) {
        defaultCase(node);
    }

    public void caseABracketedNumberCharacterSubstring(ABracketedNumberCharacterSubstring node) {
        defaultCase(node);
    }

    public void caseADotZeeCharacterSubstring(ADotZeeCharacterSubstring node) {
        defaultCase(node);
    }

    public void caseABracketedNumber(ABracketedNumber node) {
        defaultCase(node);
    }

    public void caseANumberNot88Number(ANumberNot88Number node) {
        defaultCase(node);
    }

    public void caseANumber88Number(ANumber88Number node) {
        defaultCase(node);
    }

    public void caseTWhiteSpace(TWhiteSpace node) {
        defaultCase(node);
    }

    public void caseTComment(TComment node) {
        defaultCase(node);
    }

    public void caseTDot(TDot node) {
        defaultCase(node);
    }

    public void caseTComma(TComma node) {
        defaultCase(node);
    }

    public void caseTSlash(TSlash node) {
        defaultCase(node);
    }

    public void caseTPlus(TPlus node) {
        defaultCase(node);
    }

    public void caseTMinus(TMinus node) {
        defaultCase(node);
    }

    public void caseTStar(TStar node) {
        defaultCase(node);
    }

    public void caseTDollar(TDollar node) {
        defaultCase(node);
    }

    public void caseTLparen(TLparen node) {
        defaultCase(node);
    }

    public void caseTRparen(TRparen node) {
        defaultCase(node);
    }

    public void caseTNumber88(TNumber88 node) {
        defaultCase(node);
    }

    public void caseTNumberNot88(TNumberNot88 node) {
        defaultCase(node);
    }

    public void caseTAlphanumericLiteral(TAlphanumericLiteral node) {
        defaultCase(node);
    }

    public void caseTNumericLiteral(TNumericLiteral node) {
        defaultCase(node);
    }

    public void caseTDotZee(TDotZee node) {
        defaultCase(node);
    }

    public void caseTAll(TAll node) {
        defaultCase(node);
    }

    public void caseTAre(TAre node) {
        defaultCase(node);
    }

    public void caseTAscending(TAscending node) {
        defaultCase(node);
    }

    public void caseTBinary(TBinary node) {
        defaultCase(node);
    }

    public void caseTBlank(TBlank node) {
        defaultCase(node);
    }

    public void caseTBy(TBy node) {
        defaultCase(node);
    }

    public void caseTCharacter(TCharacter node) {
        defaultCase(node);
    }

    public void caseTComp(TComp node) {
        defaultCase(node);
    }

    public void caseTComp1(TComp1 node) {
        defaultCase(node);
    }

    public void caseTComp2(TComp2 node) {
        defaultCase(node);
    }

    public void caseTComp3(TComp3 node) {
        defaultCase(node);
    }

    public void caseTComp4(TComp4 node) {
        defaultCase(node);
    }

    public void caseTComp5(TComp5 node) {
        defaultCase(node);
    }

    public void caseTDate(TDate node) {
        defaultCase(node);
    }

    public void caseTDepending(TDepending node) {
        defaultCase(node);
    }

    public void caseTDescending(TDescending node) {
        defaultCase(node);
    }

    public void caseTDisplay(TDisplay node) {
        defaultCase(node);
    }

    public void caseTDisplay1(TDisplay1 node) {
        defaultCase(node);
    }

    public void caseTExternal(TExternal node) {
        defaultCase(node);
    }

    public void caseTFiller(TFiller node) {
        defaultCase(node);
    }

    public void caseTFormat(TFormat node) {
        defaultCase(node);
    }

    public void caseTFunctionPointer(TFunctionPointer node) {
        defaultCase(node);
    }

    public void caseTGlobal(TGlobal node) {
        defaultCase(node);
    }

    public void caseTHighValues(THighValues node) {
        defaultCase(node);
    }

    public void caseTIndex(TIndex node) {
        defaultCase(node);
    }

    public void caseTIndexed(TIndexed node) {
        defaultCase(node);
    }

    public void caseTIs(TIs node) {
        defaultCase(node);
    }

    public void caseTJustified(TJustified node) {
        defaultCase(node);
    }

    public void caseTKey(TKey node) {
        defaultCase(node);
    }

    public void caseTLeading(TLeading node) {
        defaultCase(node);
    }

    public void caseTLeft(TLeft node) {
        defaultCase(node);
    }

    public void caseTLowValues(TLowValues node) {
        defaultCase(node);
    }

    public void caseTNational(TNational node) {
        defaultCase(node);
    }

    public void caseTNative(TNative node) {
        defaultCase(node);
    }

    public void caseTNulls(TNulls node) {
        defaultCase(node);
    }

    public void caseTObject(TObject node) {
        defaultCase(node);
    }

    public void caseTOccurs(TOccurs node) {
        defaultCase(node);
    }

    public void caseTOn(TOn node) {
        defaultCase(node);
    }

    public void caseTPackedDecimal(TPackedDecimal node) {
        defaultCase(node);
    }

    public void caseTPicture(TPicture node) {
        defaultCase(node);
    }

    public void caseTPointer(TPointer node) {
        defaultCase(node);
    }

    public void caseTProcedurePointer(TProcedurePointer node) {
        defaultCase(node);
    }

    public void caseTQuotes(TQuotes node) {
        defaultCase(node);
    }

    public void caseTRedefines(TRedefines node) {
        defaultCase(node);
    }

    public void caseTReference(TReference node) {
        defaultCase(node);
    }

    public void caseTRenames(TRenames node) {
        defaultCase(node);
    }

    public void caseTRight(TRight node) {
        defaultCase(node);
    }

    public void caseTSeparate(TSeparate node) {
        defaultCase(node);
    }

    public void caseTSign(TSign node) {
        defaultCase(node);
    }

    public void caseTSpaces(TSpaces node) {
        defaultCase(node);
    }

    public void caseTSynchronized(TSynchronized node) {
        defaultCase(node);
    }

    public void caseTThrough(TThrough node) {
        defaultCase(node);
    }

    public void caseTTimes(TTimes node) {
        defaultCase(node);
    }

    public void caseTTo(TTo node) {
        defaultCase(node);
    }

    public void caseTTrailing(TTrailing node) {
        defaultCase(node);
    }

    public void caseTUsage(TUsage node) {
        defaultCase(node);
    }

    public void caseTValue(TValue node) {
        defaultCase(node);
    }

    public void caseTValues(TValues node) {
        defaultCase(node);
    }

    public void caseTWhen(TWhen node) {
        defaultCase(node);
    }

    public void caseTZeros(TZeros node) {
        defaultCase(node);
    }

    public void caseTDataName(TDataName node) {
        defaultCase(node);
    }

    public void caseTUnknown(TUnknown node) {
        defaultCase(node);
    }

    public void caseEOF(EOF node) {
        defaultCase(node);
    }

    public void defaultCase(Node node) {
    }
}
